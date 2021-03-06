package org.narph.hstt.service.xml;

import org.apache.log4j.Logger;
import org.narph.hstt.dao.*;
import org.narph.hstt.model.*;
import org.narph.hstt.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 08.04.12
 * Time: 18:34
 * <p/>
 * This DOM Parser reads the given input file and stores the Objects defined by HSTT.xml in POJOs and forwards them
 * into the DAO Layer. Preexisting Solutions are skipped in this process.
 */
@Service
public class DOMParserHSTT implements ImportService {

    private static final Logger LOGGER = Logger.getLogger("hstt_import");

    @Autowired
    private ConstraintDAO constraintDAO;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private EventGroupDAO eventGroupDAO;
    @Autowired
    private EventResourceDAO eventResourceDAO;
    @Autowired
    private InstanceDAO instanceDAO;
    @Autowired
    private ResourceDAO resourceDAO;
    @Autowired
    private ResourceGroupDAO resourceGroupDAO;
    @Autowired
    private ResourceTypeDAO resourceTypeDAO;
    @Autowired
    private TimeDAO timeDAO;
    @Autowired
    private TimeGroupDAO timeGroupDAO;


    public boolean load(String[] args) throws Exception {
        LOGGER.debug("DOM Parser loading...");
        // Document doc = null;

        try {
            LOGGER.debug("DOM Parser: setting up DocumentBuilder");
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();

            // FileReader fr = new FileReader(args[0]);
            File xmlFile = new File(args[0]);
            LOGGER.debug("DOM Parser: parsing File");
            Document doc = docBuilder.parse(xmlFile);

            LOGGER.debug("DOM Parser: reading Nodes from root");
            Element root = doc.getDocumentElement();

            NodeList nodes = root.getChildNodes();
            LOGGER.debug("DOM Parser: root: " + root.getTagName() + ", " + nodes.getLength());
            for (int n = 0; n < nodes.getLength(); n++) {
                Node node = nodes.item(n);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    if (element.getTagName().equals("MetaData")) {
                        LOGGER.debug("DOM - reading MetaData");


                    } else if (element.getTagName().equals("Instances")) {
                        LOGGER.debug("DOM - reading Instances");
                        NodeList instanceNodes = node.getChildNodes();
                        for (int i = 0; i < instanceNodes.getLength(); i++) {
                            LOGGER.debug("DOM - found Instance: " + instanceNodes.item(i).toString());
                            Instance instance = new Instance();

                            if (instanceNodes.item(i) != null) {
                                Node instanceNode = instanceNodes.item(i);
                                if (instanceNode instanceof Element) {
                                    Element instanceElement = (Element) instanceNode;
                                    LOGGER.debug("DOM - instance handling -> " + instanceElement.getTagName() +
                                            ", " + instanceElement.getAttribute("Id"));
                                    instance.setId(instanceElement.getAttribute("Id"));
                                    LOGGER.debug(" has interface: " + (instanceDAO != null));
                                    instanceDAO.create(instance);
                                }
                            }
                            NodeList infoNodes = instanceNodes.item(i).getChildNodes();
                            for (int j = 0; j < infoNodes.getLength(); j++) {
                                Node infoNode = infoNodes.item(j);

                                if (infoNode.getNodeName().equals("Metadata")) {
                                    LOGGER.debug("DOM - reading MetaData");
                                }
                                if (infoNode.getNodeName().equals("Times")) {
                                    LOGGER.debug("DOM - reading Times");
                                    readTimes(instance, infoNode);
                                }
                                if (infoNode.getNodeName().equals("Resources")) {
                                    LOGGER.debug("DOM - reading Resources");
                                    readResources(instance, infoNode);
                                }
                                if (infoNode.getNodeName().equals("Events")) {
                                    LOGGER.debug("DOM - reading Events");
                                    readEvents(instance, infoNode);
                                }
                                if (infoNode.getNodeName().equals("Constraints")) {
                                    LOGGER.debug("DOM - reading Constraints");
                                    readConstraints(instance, infoNode);
                                }
                            }
                        }


                    } else if (element.getTagName().equals("SolutionGroups")) {

                    }
                }
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("Parser Error DOM: " + e.getLocalizedMessage() + e.fillInStackTrace());
            LOGGER.debug(e);
        }

        return false;
    }

    /**
     * reading and extracting <Times></Times>
     *
     * @param instance  Problem Instance this belongs to
     * @param timesNode the <Times></Times> element
     */
    private void readTimes(Instance instance, Node timesNode) {
        NodeList nodeList = timesNode.getChildNodes();
        // TimeGroups and Times
        for (int n = 0; n < nodeList.getLength(); n++) {
            Node node = nodeList.item(n);
            if (node instanceof Element) {
                Element element = (Element) node;
                if (element.getTagName().equals("TimeGroups")) {
                    NodeList groupList = node.getChildNodes();
                    for (int g = 0; g < groupList.getLength(); g++) {
                        Node group = groupList.item(g);
                        if (group instanceof Element) {
                            Element groupElement = (Element) group;
                            LOGGER.debug("DOM - reading TimeGroup: " + groupElement.getAttribute("Id"));
                            TimeGroup timeGroup = new TimeGroup();
                            timeGroup.setId(groupElement.getAttribute("Id"));
                            timeGroup.setInstance(instance);
                            timeGroup.setName(getElementTextByName(groupElement, "Name"));
                            LOGGER.debug("DOM - saving TimeGroup: " + timeGroup.toString());
                            if (groupElement.getTagName().equals("TimeGroup"))
                                timeGroup.setType(TimeGroup.TimeGroupType.TIMEGROUP);
                            if (groupElement.getTagName().equals("Day")) timeGroup.setType(TimeGroup.TimeGroupType.DAY);
                            if (groupElement.getTagName().equals("Week"))
                                timeGroup.setType(TimeGroup.TimeGroupType.WEEK);
                            timeGroupDAO.create(timeGroup);
                        }
                    }
                } else if (element.getTagName().equals("Time")) {
                    LOGGER.debug("DOM - reading Time: " + element.getAttribute("Id"));
                    Time time = new Time();
                    time.setId(element.getAttribute("Id"));
                    time.setInstance(instance);
                    time.setName(getElementTextByName(element, "Name"));
                    LOGGER.debug("DOM - saving Time: " + time.toString());
                    timeDAO.create(time);
                    if (element.getElementsByTagName("Week").getLength() > 0) {
                        time.setWeek(getElementAttributeByNames(element, "Week", "Reference"));
                    }
                    if (element.getElementsByTagName("Day").getLength() > 0) {
                        time.setWeek(getElementAttributeByNames(element, "Day", "Reference"));
                    }
                    if (element.getElementsByTagName("TimeGroups").getLength() > 0) {
                        NodeList nl = element.getElementsByTagName("TimeGroups").item(0).getChildNodes();
                        for (int i = 0; i < nl.getLength(); i++) {
                            if (nl.item(i) instanceof Element) {
                                Element e = (Element) nl.item(i);
                                TimeGroup group = timeGroupDAO.getById(e.getAttribute("Reference"));
                                group.addTime(time);
                                time.addTimeGroup(group);
                            }
                        }
                    }
                    timeDAO.update(time);
                }
            }
        }
    }

    private void readResources(Instance instance, Node resourcesNode) {
        NodeList nodeList = resourcesNode.getChildNodes();
        for (int r = 0; r < nodeList.getLength(); r++) {
            Node resourceNode = nodeList.item(r);
            if (resourceNode instanceof Element) {
                Element resourceElement = (Element) resourceNode;
                if (resourceElement.getTagName().equals("ResourceTypes")) {
                    NodeList typeList = resourceNode.getChildNodes();
                    for (int t = 0; t < typeList.getLength(); t++) {
                        if (typeList.item(t) instanceof Element) {
                            Element typeElement = (Element) typeList.item(t);
                            LOGGER.debug("DOM - reading ResourceType: " + typeElement.getAttribute("Id"));
                            ResourceType type = new ResourceType();
                            type.setId(typeElement.getAttribute("Id"));
                            type.setInstance(instance);
                            type.setName(getElementTextByName(typeElement, "Name"));
                            resourceTypeDAO.create(type);
                        }
                    }
                } else if (resourceElement.getTagName().equals("ResourceGroups")) {
                    NodeList groupList = resourceNode.getChildNodes();
                    for (int g = 0; g < groupList.getLength(); g++) {
                        if (groupList.item(g) instanceof Element) {
                            Element groupElement = (Element) groupList.item(g);
                            LOGGER.debug("DOM - reading ResourceGroup: " + groupElement.getAttribute("Id"));
                            ResourceGroup group = new ResourceGroup();
                            group.setId(groupElement.getAttribute("Id"));
                            group.setInstance(instance);
                            group.setName(getElementTextByName(groupElement, "Name"));
                            group.setType(resourceTypeDAO.getById(getElementAttributeByNames(groupElement, "ResourceType", "Reference")));
                            resourceGroupDAO.create(group);
                        }
                    }
                } else if (resourceElement.getTagName().equals("Resource")) {
                    LOGGER.debug("DOM - reading Resource: " + resourceElement.getAttribute("Id") + " type " + getElementAttributeByNames(resourceElement, "ResourceType", "Reference"));
                    Resource resource = new Resource();
                    resource.setId(resourceElement.getAttribute("Id"));
                    resource.setInstance(instance);
                    resource.setName(getElementTextByName(resourceElement, "Name"));
                    resource.setType(resourceTypeDAO.getById(getElementAttributeByNames(resourceElement, "ResourceType", "Reference")));
                    resourceDAO.create(resource);
                    List<ResourceGroup> groupList = new ArrayList<ResourceGroup>();
                    NodeList nl = resourceElement.getElementsByTagName("ResourceGroups");
                    if (nl.getLength() > 0) {
                        nl = nl.item(0).getChildNodes();
                        for (int l = 0; l < nl.getLength(); l++) {
                            if (nl.item(l) instanceof Element) {
                                Element el = (Element) nl.item(l);
                                ResourceGroup group = resourceGroupDAO.getById(el.getAttribute("Reference"));
                                group.addResource(resource);
                                groupList.add(group);

                            }
                        }
                    }
                    resource.setGroups(groupList);
                    resourceDAO.update(resource);
                }
            }
        }
    }

    private void readEvents(Instance instance, Node eventsNode) {
        NodeList nodeList = eventsNode.getChildNodes();
        for (int e = 0; e < nodeList.getLength(); e++) {
            Node eventNode = nodeList.item(e);
            if (eventNode instanceof Element) {
                Element eventElement = (Element) eventNode;
                if (eventElement.getTagName().equals("EventGroups")) {
                    NodeList groupList = eventElement.getChildNodes();
                    for (int g = 0; g < groupList.getLength(); g++) {
                        if (groupList.item(g) instanceof Element) {
                            Element groupElement = (Element) groupList.item(g);
                            LOGGER.debug("DOM - reading EventGroup: " + groupElement.getAttribute("Id"));

                            EventGroup group = new EventGroup();
                            group.setId(groupElement.getAttribute("Id"));
                            group.setInstance(instance);
                            group.setName(getElementTextByName(groupElement, "Name"));
                            if (groupElement.getTagName().equals("EventGroup")) {
                                eventGroupDAO.create(group);
                            } else if (groupElement.getTagName().equals("Course")) {
                                Course c = new Course();
                                c.setId(group.getId());
                                c.setInstance(group.getInstance());
                                c.setName(group.getName());
                                c.setEvents(group.getEvents());
                                c.setConstraints(group.getConstraints());
                                courseDAO.create(c);
                            }
                        }
                    }
                } else if (eventElement.getTagName().equals("Event")) {  // start element <Event>
                    /*
                        <Events>
                            * Event Id +Color
                                Name
                                Duration
                                + Workload
                                + Course
                                + Time
                                + Resources
                                + ResourceGroups
                                + EventGroups

                     */
                    LOGGER.debug("DOM - reading Event: " + eventElement.getAttribute("Id"));
                    Event event = new Event();
                    event.setId(eventElement.getAttribute("Id"));
                    if (eventElement.hasAttribute("Color")) {
                        event.setColor(eventElement.getAttribute("Color"));
                    }
                    event.setInstance(instance);
                    event.setName(getElementTextByName(eventElement, "Name"));
                    int d = Integer.parseInt(getElementTextByName(eventElement, "Duration"));
                    event.setDuration(d);
                    LOGGER.debug("DOM - creating Event: " + event);
                    eventDAO.create(event);

                    NodeList subNodes = eventElement.getChildNodes();
                    for (int s = 0; s < subNodes.getLength(); s++) { // start reading optional elements
                        if (subNodes.item(s) instanceof Element) {
                            Element subElement = (Element) subNodes.item(s);

                            if (subElement.getTagName().equals("Workload")) {
                                d = Integer.parseInt(getElementTextByName(eventElement, "Workload"));
                                event.setWorkload(d);
                            } else if (subElement.getTagName().equals("Course")) {
                                Course course = courseDAO.getById(subElement.getAttribute("Reference"));
                                course.addEvent(event);
                                event.setCourse(course);
                            } else if (subElement.getTagName().equals("Time")) {
                                event.setTime(timeDAO.getById(subElement.getAttribute("Reference")));
                            } else if (subElement.getTagName().equals("Resources")) {
                                /*
                                <Resources>
                                    * Resource +Reference
                                        + Role
                                        + ResourceType
                                        + Workload
                                 */
                                NodeList nl = subElement.getChildNodes(); // List of Resources in instance.events.event.resources
                                for (int i = 0; i < nl.getLength(); i++) { // cycling Resources
                                    if (nl.item(i) instanceof Element) {
                                        Element sE = (Element) nl.item(i); // Resource element
                                        EventResource eventResource = new EventResource();

                                        eventResource.setEvent(event);
                                        event.addResource(eventResource);
                                        eventResourceDAO.create(eventResource);

                                        if (sE.hasAttribute("Reference")) {
                                            Resource resource = resourceDAO.getById(sE.getAttribute("Reference"));
                                            eventResource.setReference(resource);
                                        }

                                        if (sE.getElementsByTagName("Role").getLength() > 0) {
                                            eventResource.setRole(getElementTextByName(sE, "Role"));
                                        }

                                        if (sE.getElementsByTagName("ResourceType").getLength() > 0) {
                                            ResourceType resourceType = resourceTypeDAO.getById(getElementAttributeByNames(sE,"ResourceType","Reference"));
                                            eventResource.setType(resourceType);
                                        }

                                        if (sE.getElementsByTagName("Workload").getLength() > 0) {
                                            int h = Integer.parseInt(getElementTextByName(sE, "Workload"));
                                            eventResource.setWorkload(h);
                                        }
                                        eventResourceDAO.update(eventResource);
                                    }
                                }
                            } else if (subElement.getTagName().equals("ResourceGroups")) {
                                /*
                                    <ResourceGroups>
                                        * ResourceGroup Reference
                                 */
                                NodeList nl = subElement.getChildNodes();
                                for(int i=0; i<nl.getLength(); i++) {
                                    if(nl.item(i) instanceof Element) {
                                        Element rgElement = (Element) nl.item(i);
                                        ResourceGroup rg = resourceGroupDAO.getById(rgElement.getAttribute("Reference"));
                                        event.addResourceGroup(rg);
                                        resourceGroupDAO.update(rg);
                                    }
                                }
                            } else if (subElement.getTagName().equals("EventGroups")) {
                                /*
                                    <EventGroups>
                                        * EventGroup Reference
                                 */
                                //System.out.println("reading eventgroups");
                                NodeList nl = subElement.getChildNodes();
                                for(int i=0; i<nl.getLength(); i++) {
                                    if(nl.item(i) instanceof Element) {
                                        Element egElement = (Element) nl.item(i);
                                        EventGroup eg = eventGroupDAO.getById(egElement.getAttribute("Reference"));
                                        event.addEventGroup(eg);
                                        eg.addEvent(event);
                                        eventGroupDAO.update(eg);
                                    }
                                }
                            }
                        }
                    }
                    eventDAO.update(event);
                }
            }
        }
    }

    private void readConstraints(Instance instance, Node constraintsNode) {
        NodeList nodeList = constraintsNode.getChildNodes();
        for (int c = 0; c < nodeList.getLength(); c++) {
            if (nodeList.item(c) instanceof Element) {

                Element constraintElement = (Element) nodeList.item(c);
                LOGGER.debug("DOM - reading Constraint: " + constraintElement.getAttribute("Id"));

                Constraint constraint = new Constraint();
                constraint.setInstance(instance);
                constraint.setId(constraintElement.getAttribute("Id"));
                constraint.setName(getElementTextByName(constraintElement, "Name"));
                int d = Integer.parseInt(getElementTextByName(constraintElement,"Weight"));
                constraint.setWeight(d);
                Constraint.CostFunction cf = Constraint.CostFunction.valueOf(getElementTextByName(constraintElement, "CostFunction"));
                constraint.setCostFunction(cf);
                constraint.setRequired(getElementTextByName(constraintElement,"Required").equals("true"));
                constraint.setType(Constraint.ConstraintType.valueOf(constraintElement.getTagName()));
                //String constraintType = constraintElement.getTagName();
                constraintDAO.create(constraint);

                //TODO read Events
                //TODO read EventGroups
                //TODO read Times
                //TODO read TimeGroups
                //TODO read Resources
                //TODO read ResourceGroups
            }
        }
    }

    private String getElementTextByName(Element element, String name) {
        if (element.getElementsByTagName(name).getLength() > 0) {
            return element.getElementsByTagName(name).item(0).getTextContent();
        }
        return "";
    }

    private String getElementAttributeByNames(Element element, String eName, String aName) {
        if (element.getElementsByTagName(eName).getLength() > 0) {
            Element e = (Element) element.getElementsByTagName(eName).item(0);
            return e.getAttribute(aName);
        }
        return "";
    }
}
