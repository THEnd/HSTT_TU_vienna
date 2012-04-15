package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 15:09
 */
@Entity
public class SplitEventsConstraint extends Constraint {
    @Basic
    private int minimumDuration;

    @Basic
    private int minimumAmount;

    @Basic
    private int maximumAmount;

    @Basic
    private int maximumDuration;


    public int getMinimumDuration() {
        return minimumDuration;
    }

    public void setMinimumDuration(int minimumDuration) {
        this.minimumDuration = minimumDuration;
    }

    public int getMaximumDuration() {
        return maximumDuration;
    }

    public void setMaximumDuration(int maximumDuration) {
        this.maximumDuration = maximumDuration;
    }


    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }


    public int getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }
}
