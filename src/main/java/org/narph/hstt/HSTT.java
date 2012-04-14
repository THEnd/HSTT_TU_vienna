package org.narph.hstt;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.narph.hstt.service.ImportService;
import org.narph.hstt.service.xml.DOMParserHSTT;
import org.narph.hstt.service.xml.SAXParserHSTT;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 17:11
 */
public class HSTT {

    private static final Logger LOGGER = Logger.getLogger("hstt");




    public static void main(final String[] args) throws Exception {
        //ApplicationContext acx =
        try{
            new ClassPathXmlApplicationContext("file:spring-config.xml");
        } catch (Exception e) {

        }


        PropertyConfigurator.configureAndWatch("log4j.properties");
        LOGGER.info("welcome to the narph HSTT solver");


        process("examples\\BrazilInstance1.xml");
        process("examples\\EnglandStPaul.xml");

        LOGGER.info("shut down, bye bye");
    }

    public static void process(String file) {
        ImportService saxParser = new SAXParserHSTT();
        ImportService domParser = new DOMParserHSTT();

        String[] args = new String[1];
        args[0] = file;
        /*
        try {
            saxParser.load(args);
        } catch (Exception e) {
            LOGGER.error("Parser Error calling SAX: " + e.getLocalizedMessage());
        }
        */

        try {
            domParser.load(args);
        } catch (Exception e) {
            LOGGER.error("Parser Error calling DOM: " + e.getLocalizedMessage());
        }


    }
}
