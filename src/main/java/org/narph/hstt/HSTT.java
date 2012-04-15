package org.narph.hstt;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.narph.hstt.service.ImportService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

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
        System.out.println("starting up, please wait. initialization can take a while on first run.");
        PropertyConfigurator.configureAndWatch("log4j.properties");
        LOGGER.info("welcome to the narph HSTT solver");

        try{
            beanFactory = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        } catch (Exception e) {
            LOGGER.error(" " + e.getLocalizedMessage());
        }
        System.out.println("finished initialization");

        //process("examples\\GreeceThirdHighSchoolPatras2010.xml");
        //process("examples\\BrazilInstance1.xml"); DenmarkSmallSchool.xml
        //process("examples\\EnglandStPaul.xml"); AustraliaTES99.xml
        String in_file = "examples\\DenmarkSmallSchool.xml";
        String out_file = "examples\\BrazilInstance1.xml";

        for(int i=0; i<args.length; i++) {
            if(args[i].equals("-i")) {
                if(args.length>i) {
                    i++;
                    in_file = args[i];
                }
            }
            if(args[i].equals("-o")) {
                if(args.length>i) {
                    i++;
                    out_file = args[i];
                }
            }
        }
        System.out.println("start reading file ["+in_file+"]");
        Date stopwatch = new Date();
        process(in_file);
        System.out.println("finished reading file in [" + ((new Date()).getTime() - stopwatch.getTime()) + "ms]");

        System.out.println("generating timeslots and events...");
        //TODO calculate solution
        System.out.println("calculating solution...");



        //TODO export result
        System.out.println("finished");

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
