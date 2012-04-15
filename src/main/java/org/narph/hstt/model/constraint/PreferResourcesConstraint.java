package org.narph.hstt.model.constraint;

import org.narph.hstt.model.Constraint;
import org.narph.hstt.model.Resource;
import org.narph.hstt.model.ResourceGroup;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 07.04.12
 * Time: 15:11
 */
@Entity
public class PreferResourcesConstraint extends Constraint {

    @Basic
    private String role;

    @ManyToMany
    private Collection<Resource> resources;

    @ManyToMany
    private Collection<ResourceGroup> resourcegroups;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Resource> getResources() {
        return resources;
    }

    public void setResources(Collection<Resource> resources) {
        this.resources = resources;
    }

    public Collection<ResourceGroup> getResourcegroups() {
        return resourcegroups;
    }

    public void setResourcegroups(Collection<ResourceGroup> resourcegroups) {
        this.resourcegroups = resourcegroups;
    }
}
