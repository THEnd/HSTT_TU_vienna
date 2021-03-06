package org.narph.hstt.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 13:30
 */
@Entity
public class Event extends ConstraintEntity {

    private static final long serialVersionUID = -4795814377342057359L;

    @Id
    private String id;

    @Basic
    private String name;

    @Basic
    private String color;

    @Basic
    private int duration;

    @Basic
    private int workload;

    @ManyToOne
    private Time time;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "events")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EventGroup> groups = new ArrayList<EventGroup>();

    @OneToOne
    private Course course;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EventResource> resources = new ArrayList<EventResource>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ResourceGroup> resourcegroups = new ArrayList<ResourceGroup>();

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<EventGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<EventGroup> groups) {
        this.groups = groups;
    }

    public void addEventGroup(EventGroup group) {
        this.groups.add(group);
    }

    public boolean removeEventGroup(EventGroup group) {
        return this.groups.remove(group);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<EventResource> getResources() {
        return resources;
    }

    public void setResources(List<EventResource> resources) {
        this.resources = resources;
    }

    public void addResource(EventResource resource) {
        this.resources.add(resource);
    }

    public boolean removeResource(EventResource resource) {
        return this.resources.remove(resource);
    }

    public List<ResourceGroup> getResourcegroups() {
        return resourcegroups;
    }

    public void setResourcegroups(List<ResourceGroup> resourcegroups) {
        this.resourcegroups = resourcegroups;
    }

    public void addResourceGroup(ResourceGroup group) {
        this.resourcegroups.add(group);
    }

    public boolean removeResourceGroup(ResourceGroup group) {
        return this.resourcegroups.remove(group);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Event");
        sb.append("{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", workload=").append(workload);
        sb.append('}');
        return sb.toString();
    }
}
