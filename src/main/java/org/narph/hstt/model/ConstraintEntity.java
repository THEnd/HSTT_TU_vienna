package org.narph.hstt.model;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 08.04.12
 * Time: 15:02
 */
@MappedSuperclass
public abstract class ConstraintEntity implements Serializable{

    private static final long serialVersionUID = 69992103831661416L;

    @ManyToMany
    private List<Constraint> constraints;


    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }


    @ManyToOne(optional = false)
    private Instance instance;

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }
}
