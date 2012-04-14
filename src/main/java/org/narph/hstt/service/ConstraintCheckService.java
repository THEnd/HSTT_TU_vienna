package org.narph.hstt.service;

import org.narph.hstt.model.ConstraintEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 18:36
 */
public interface ConstraintCheckService<T extends Serializable> {

    public void setConstraints(List<T> constraints);

    public boolean isSet();

    public boolean clearConstraints();

    /**
     * get the total weight of all violations for this constraint.
     * @return total weight of violations of a specific constraint
     */
    public int totalViolations();

    /**
     * get the weight of the violations of a constraint on a specific entity.
     * @param constraintEntity the entity to be checked
     * @return total weight of violations of a specific constraint on a specific entity
     */
    public int getViolations(ConstraintEntity constraintEntity);

}
