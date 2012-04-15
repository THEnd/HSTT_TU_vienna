package org.narph.hstt.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 13:30
 */
@Entity
public class Time implements Serializable {
    private static final long serialVersionUID = -8076949988566166062L;

    @Id
    private String id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "times")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TimeGroup> group = new ArrayList<TimeGroup>();

    @ManyToOne(optional = false)
    private Instance instance;

    @Basic
    private String week;
    @Basic
    private String day;


    public List<TimeGroup> getGroup() {
        return group;
    }

    public void setGroup(List<TimeGroup> group) {
        this.group = group;
    }

    public void addTimeGroup(TimeGroup timeGroup) {
        this.group.add(timeGroup);
    }

    public boolean removeTimeGroup(TimeGroup timeGroup) {
        return this.group.remove(timeGroup);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Time");
        sb.append("{day='").append(day).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", week='").append(week).append('\'');
        sb.append(", instance=").append(instance);
        sb.append(", group=").append(group);
        sb.append('}');
        return sb.toString();
    }
}
