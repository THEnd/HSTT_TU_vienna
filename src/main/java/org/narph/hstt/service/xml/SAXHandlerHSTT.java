package org.narph.hstt.service.xml;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 08.04.12
 * Time: 17:53
 */
public class SAXHandlerHSTT extends DefaultHandler {

    private static final Logger LOGGER = Logger.getLogger("hstt_import");

    private boolean is_instance = false;
    private String id_instance;

    private boolean is_inDefinition = false;

    public SAXHandlerHSTT() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.debug("Start doc");
        super.startDocument();    //TODO change body of overridden methods.
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.debug("End doc");
        super.endDocument();    //TODO change body of overridden methods.
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        LOGGER.debug("Start Element: " + uri + ", " + localName);

        if (localName.equals("Instance")) {
            is_instance = true;
            id_instance = attributes.getValue("Id");
        }

        if(localName.equals("Times") || localName.equals("Resources") || localName.equals("Events") || localName.equals("Constraints")) {
            is_inDefinition = true;
        }

        if(is_instance && is_inDefinition) {
            if(localName.equals("Time")) {
               LOGGER.debug("Time -> " + attributes.toString());
            }
        }
        super.startElement(uri, localName, qName, attributes);    //TODO change body of overridden methods.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        LOGGER.debug("End Element: " + uri + ", " + localName);

        if(localName.equals("Times") || localName.equals("Resources") || localName.equals("Events") || localName.equals("Constraints")) {
            is_inDefinition = false;
        }

        if (localName.equals("Instance")) is_instance = false;

        super.endElement(uri, localName, qName);    //TODO change body of overridden methods.
    }
}
