package org.narph.hstt;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.narph.hstt.service.ImportService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 17:11
 */
public class HSTT {

    private static final Logger LOGGER = Logger.getLogger("hstt");

    private static BeanFactory beanFactory;

    public static void main(final String[] args) throws Exception {

        PropertyConfigurator.configureAndWatch("log4j.properties");
        LOGGER.info("welcome to the narph HSTT solver");

        try{
            beanFactory = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        } catch (Exception e) {
            LOGGER.error(" " + e.getLocalizedMessage());
        }

        process("examples\\BrazilInstance1.xml");
        //process("examples\\EnglandStPaul.xml");

        LOGGER.info("shut down, bye bye");
    }

    public static void process(String file) {
        //ImportService saxParser = new SAXParserHSTT();

        ImportService domParser = (ImportService) beanFactory.getBean("DOMParserHSTT");

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
