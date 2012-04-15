package org.narph.hstt.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 18:13
 */
@Entity
public class ResourceGroup extends ConstraintEntity {

    private static final long serialVersionUID = 5282746949775593840L;

    @Id
    private String id;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Resource> resources = new ArrayList<Resource>();

    @Basic
    private String name;

    @ManyToOne(optional = false)
    private ResourceType type;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
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

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public boolean removeResource(Resource resource) {
        return this.resources.remove(resource);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ResourceGroup");
        sb.append("{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
