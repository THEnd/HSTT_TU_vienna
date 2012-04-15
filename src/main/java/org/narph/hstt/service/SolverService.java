package org.narph.hstt.service;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 16:16
 */
public interface SolverService {

    /**
     * let the solver run on a given input
     * @return
     */
    public int run();

    /**
     * specify the input for the solver
     * @param args array of arguments to pass on to the solver
     */
    public void setMetadata(String[] args);

}
