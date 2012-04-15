package org.narph.hstt.model;

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

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "events")
    private List<EventGroup> groups = new ArrayList<EventGroup>();

    @OneToOne
    private Course course;

    @OneToMany(mappedBy = "event")
    private List<EventResource> resources = new ArrayList<EventResource>();

    @ManyToMany
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

    public List<ResourceGroup> getResourcegroups() {
        return resourcegroups;
    }

    public void setResourcegroups(List<ResourceGroup> resourcegroups) {
        this.resourcegroups = resourcegroups;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Event");
        sb.append("{color='").append(color).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", duration='").append(duration).append('\'');
        sb.append(", workload=").append(workload);
        sb.append(", time=").append(time);
        sb.append(", groups=").append(groups);
        sb.append(", course=").append(course);
        sb.append(", resources=").append(resources);
        sb.append(", resourcegroups=").append(resourcegroups);
        sb.append('}');
        return sb.toString();
    }
}
