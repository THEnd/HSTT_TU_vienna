package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 15:07
 */
@Entity
public class AssignResourceConstraint extends Constraint {
    @Basic
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
