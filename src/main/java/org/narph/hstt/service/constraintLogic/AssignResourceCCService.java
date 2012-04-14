package org.narph.hstt.service.constraintLogic;

import org.narph.hstt.model.ConstraintEntity;
import org.narph.hstt.model.constraint.AssignResourceConstraint;
import org.narph.hstt.service.ConstraintCheckService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 20:50
 */
public class AssignResourceCCService implements ConstraintCheckService<AssignResourceConstraint> {



    public int totalViolations() {
        return 0;  //TODO change body of implemented methods.
    }

    public int getViolations(ConstraintEntity constraintEntity) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setConstraints(List<AssignResourceConstraint> assignResourceConstraints) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isSet() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean clearConstraints() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
