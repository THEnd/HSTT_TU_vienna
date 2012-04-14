package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;
import org.narph.hstt.model.TimeGroup;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 16:20
 */
@Entity
public class LimitBusyTimesConstraint extends Constraint {
    @Basic
    private int minimum;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    @Basic
    private int maximum;

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @ManyToMany
    private Collection<TimeGroup> timegroups;

    public Collection<TimeGroup> getTimegroups() {
        return timegroups;
    }

    public void setTimegroups(Collection<TimeGroup> timegroups) {
        this.timegroups = timegroups;
    }
}
