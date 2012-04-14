package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;
import org.narph.hstt.model.Time;
import org.narph.hstt.model.TimeGroup;

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
public class AvoidUnavailableTimesConstraint extends Constraint {
    @ManyToMany
    private Collection<Time> timegroups;

    public Collection<Time> getTimegroups() {
        return timegroups;
    }

    public void setTimegroups(Collection<Time> timegroups) {
        this.timegroups = timegroups;
    }

    @ManyToMany
    private Collection<TimeGroup> times;

    public Collection<TimeGroup> getTimes() {
        return times;
    }

    public void setTimes(Collection<TimeGroup> times) {
        this.times = times;
    }
}
