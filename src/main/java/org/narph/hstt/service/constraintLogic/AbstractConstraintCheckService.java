package org.narph.hstt.service.constraintLogic;

import org.narph.hstt.model.Constraint;
import org.narph.hstt.model.ConstraintEntity;
import org.narph.hstt.service.ConstraintCheckService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: endeMobil
 * Date: 13.04.12
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractConstraintCheckService implements ConstraintCheckService<Constraint> {

    private List<Constraint> constraintList = new ArrayList<Constraint>();

    public void setConstraints(List<Constraint> constraints) {
        constraintList = constraints;
    }

    public boolean isSet() {
        return !constraintList.isEmpty();
    }

    public boolean clearConstraints() {
        constraintList.clear();
        return !isSet();
    }

    public int totalViolations() {

        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getViolations(ConstraintEntity constraintEntity) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
