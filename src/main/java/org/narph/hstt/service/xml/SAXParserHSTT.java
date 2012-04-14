package org.narph.hstt.service.xml;

import org.apache.log4j.Logger;
import org.narph.hstt.service.ImportService;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 08.04.12
 * Time: 17:20
 */
public class SAXParserHSTT implements ImportService {

    private static final Logger LOGGER = Logger.getLogger("hstt_import");



    public boolean load(String[] args) throws Exception {
        LOGGER.debug("SAX Parser loading...");
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            SAXHandlerHSTT handler = new SAXHandlerHSTT();
            xmlReader.setContentHandler(handler);
            xmlReader.setErrorHandler(handler);

            FileReader fr = new FileReader(args[0]);
            xmlReader.parse(new InputSource(fr));

            return true;
        } catch (Exception e){
            LOGGER.error("Parsing Error SAX: " + e.getLocalizedMessage());
        }


        return false;  //TODO change body of implemented methods.
    }
}
