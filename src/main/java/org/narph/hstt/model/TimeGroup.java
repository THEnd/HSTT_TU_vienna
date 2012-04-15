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
 * Time: 18:08
 */
@Entity
public class TimeGroup implements Serializable {

    private static final long serialVersionUID = 8885560587821197245L;

    @Id
    private String id;
    @Basic
    private String name;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Time> times  = new ArrayList<Time>();

    @ManyToOne(optional = false)
    private Instance instance;



    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public void addTime(Time time) {
        this.times.add(time);
    }

    public boolean removeTime(Time time) {
        return this.times.remove(time);
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TimeGroup");
        sb.append("{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", instance=").append(instance);
        sb.append('}');
        return sb.toString();
    }
}
