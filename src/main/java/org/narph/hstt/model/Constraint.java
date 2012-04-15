package org.narph.hstt.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 13:30
 */
@Entity(name = "basicConstraint")
public class Constraint implements Serializable {

    private static final long serialVersionUID = -3544922865266049529L;

    // general fields

    @Id
    private String id;

    @Basic
    private String name;

    @Basic
    private boolean required;

    @Basic
    private int weight;

    @Basic
    private CostFunction costFunction;

    @ManyToOne(optional = false)
    private Instance instance;

    @Basic
    @NotNull
    private ConstraintType type;

    public enum ConstraintType {
        AssignResourceConstraint,
        AssignTimeConstraint,
        AvoidClashesConstraint,
        AvoidSplitAssignmentsConstraint,
        AvoidUnavailableTimesConstraint,
        ClusterBusyTimesConstraint,
        DistributeSplitEventsConstraint,
        LimitBusyTimesConstraint,
        LimitIdleTimesConstraint,
        LimitWorkloadConstraint,
        LinkEventsConstraint,
        PreferResourcesConstraint,
        PreferTimesConstraint,
        SplitEventsConstraint,
        SpreadEventsConstraint
    }

    // specific fields

    @Basic
    private String role;
    @Basic
    private int minimum;
    @Basic
    private int maximum;
    @Basic
    private int duration;
    @Basic
    private int minimumAmount;
    @Basic
    private int maximumAmount;
    @Basic
    private int minimumDuration;
    @Basic
    private int maximumDuration;

    @ManyToMany
    private List<Resource> resources = new ArrayList<Resource>();

    @ManyToMany
    private List<ResourceGroup> resourceGroups = new ArrayList<ResourceGroup>();

    @ManyToMany
    private List<Time> times = new ArrayList<Time>();

    @ManyToMany
    private List<TimeGroup> timeGroups = new ArrayList<TimeGroup>();

    @ManyToMany
    private List<Event> events = new ArrayList<Event>();

    @ManyToMany
    private List<EventGroup> eventGroups = new ArrayList<EventGroup>();

    public enum CostFunction {
        Sum,
        SumSquare,
        SquareSum,
        SumStep,
        StepSum
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CostFunction getCostFunction() {
        return costFunction;
    }

    public void setCostFunction(CostFunction costFunction) {
        this.costFunction = costFunction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumDuration() {
        return maximumDuration;
    }

    public void setMaximumDuration(int maximumDuration) {
        this.maximumDuration = maximumDuration;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public int getMinimumDuration() {
        return minimumDuration;
    }

    public void setMinimumDuration(int minimumDuration) {
        this.minimumDuration = minimumDuration;
    }

    public List<ResourceGroup> getResourceGroups() {
        return resourceGroups;
    }

    public void setResourceGroups(List<ResourceGroup> resourceGroups) {
        this.resourceGroups = resourceGroups;
    }

    public void addResourceGroup(ResourceGroup resourceGroup) {
        this.resourceGroups.add(resourceGroup);
    }

    public boolean removeResourceGroup(ResourceGroup resourceGroup) {
        return this.resourceGroups.remove(resourceGroup);
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public boolean removeResource(Resource resource) {
        return this.resources.remove(resource);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TimeGroup> getTimeGroups() {
        return timeGroups;
    }

    public void setTimeGroups(List<TimeGroup> timeGroups) {
        this.timeGroups = timeGroups;
    }

    public void addTimeGroup(TimeGroup timeGroup) {
        this.timeGroups.add(timeGroup);
    }

    public boolean removeTimeGroup(TimeGroup timeGroup) {
        return this.timeGroups.remove(timeGroup);
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public void addTime(Time time) {
        this.times.add(time);
    }

    public boolean removeTime(Time time) {
        return this.times.remove(time);
    }

    public ConstraintType getType() {
        return type;
    }

    public void setType(ConstraintType type) {
        this.type = type;
    }

    public List<EventGroup> getEventGroups() {
        return eventGroups;
    }

    public void setEventGroups(List<EventGroup> eventGroups) {
        this.eventGroups = eventGroups;
    }

    public void addEventGroup(EventGroup eventGroup) {
        this.eventGroups.add(eventGroup);
    }

    public boolean removeEventGroup(EventGroup eventGroup) {
        return this.eventGroups.remove(eventGroup);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public boolean removeEvent(Event event) {
        return this.events.remove(event);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Constraint");
        sb.append("{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", required=").append(required);
        sb.append(", costFunction=").append(costFunction);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
