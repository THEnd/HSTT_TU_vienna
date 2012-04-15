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
 * Time: 13:29
 */
@Entity
public class Resource extends ConstraintEntity {

    private static final long serialVersionUID = -6221978504816834097L;

    @Id
    private String id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "resources", cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ResourceGroup> groups = new ArrayList<ResourceGroup>();


    @ManyToOne(optional = false)
    private ResourceType type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResourceGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ResourceGroup> groups) {
        this.groups = groups;
    }

    public void addGroup(ResourceGroup group) {
        this.groups.add(group);
    }

    public boolean removeGroup(ResourceGroup group) {
        return this.groups.remove(group);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Resource");
        sb.append("{groups=").append(groups);
        sb.append(", id='").append(id).append('\'');
        sb.append(", type=").append(type);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
