package org.narph.hstt.model;

import javax.persistence.*;
import java.util.Collection;

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
    private String duration;

    @Basic
    private int workload;

    @ManyToOne
    private Time time;

    @ManyToMany(mappedBy = "events")
    private Collection<EventGroup> groups;

    @OneToOne
    private Course course;

    @OneToMany(mappedBy = "event")
    private Collection<EventResource> resources;

    @ManyToMany
    private Collection<ResourceGroup> resourcegroups;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public Collection<EventGroup> getGroups() {
        return groups;
    }

    public void setGroups(Collection<EventGroup> groups) {
        this.groups = groups;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Collection<EventResource> getResources() {
        return resources;
    }

    public void setResources(Collection<EventResource> resources) {
        this.resources = resources;
    }

    public Collection<ResourceGroup> getResourcegroups() {
        return resourcegroups;
    }

    public void setResourcegroups(Collection<ResourceGroup> resourcegroups) {
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
