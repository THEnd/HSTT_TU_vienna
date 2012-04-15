package org.narph.hstt.service;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 16:13
 */
public interface ImportService {

    /**
     * ImportServices provide methods to get data from outside of the program into this environment.
     * @param args array of arguments for the specific service
     * @return true if import was successful, false otherwise.
     * @throws Exception
     */
    public boolean load(String[] args) throws Exception;

}
