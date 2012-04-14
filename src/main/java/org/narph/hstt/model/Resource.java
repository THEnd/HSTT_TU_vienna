package org.narph.hstt.model;

import javax.persistence.*;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    private ResourceType type;

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "resources")
    private List<ResourceGroup> groups;

    public List<ResourceGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ResourceGroup> groups) {
        this.groups = groups;
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
