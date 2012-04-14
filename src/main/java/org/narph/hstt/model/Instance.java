package org.narph.hstt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 08.04.12
 * Time: 20:44
 */
@Entity
public class Instance implements Serializable {

    private static final long serialVersionUID = -4353267822497022589L;

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Instance");
        sb.append("{id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
