package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;
import org.narph.hstt.model.TimeGroup;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 16:19
 */
@Entity
public class SpreadEventsConstraint extends Constraint {
    @ManyToMany
    private Collection<TimeGroup> timegroups;

    public Collection<TimeGroup> getTimegroups() {
        return timegroups;
    }

    public void setTimegroups(Collection<TimeGroup> timegroups) {
        this.timegroups = timegroups;
    }
}
