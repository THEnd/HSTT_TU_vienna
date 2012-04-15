package org.narph.hstt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 18:38
 */
@Entity
public class EventResource implements Serializable {

    private static final long serialVersionUID = 6420496436953414402L;

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String Role;

    @Basic
    private int workload;

    @ManyToOne
    private Resource reference;

    @ManyToOne
    private ResourceType type;

    @ManyToOne(optional = false)
    private Event event;


    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Resource getReference() {
        return reference;
    }

    public void setReference(Resource reference) {
        this.reference = reference;
    }


    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("EventResource");
        sb.append("{event=").append(event);
        sb.append(", Role='").append(Role).append('\'');
        sb.append(", workload=").append(workload);
        sb.append(", id=").append(id);
        sb.append(", reference=").append(reference);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
