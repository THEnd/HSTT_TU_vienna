package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;
import org.narph.hstt.model.Time;
import org.narph.hstt.model.TimeGroup;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 15:11
 */
@Entity
public class PreferTimesConstraint extends Constraint {

    @ManyToMany
    private Collection<TimeGroup> timegroups;

    @ManyToMany
    private Collection<Time> times;

    @Basic
    private int duration;

    public Collection<TimeGroup> getTimegroups() {
        return timegroups;
    }

    public void setTimegroups(Collection<TimeGroup> timegroups) {
        this.timegroups = timegroups;
    }

    public Collection<Time> getTimes() {
        return times;
    }

    public void setTimes(Collection<Time> times) {
        this.times = times;
    }

    public int getDurations() {
        return duration;
    }

    public void setDurations(int duration) {
        this.duration = duration;
    }
}
