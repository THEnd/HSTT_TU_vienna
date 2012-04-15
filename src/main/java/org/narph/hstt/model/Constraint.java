package org.narph.hstt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 13:30
 */
@Entity(name = "basicConstraint")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "constraintType",
        discriminatorType = DiscriminatorType.STRING
)
public class Constraint implements Serializable {

    private static final long serialVersionUID = -3544922865266049529L;

    @Id
    private String id;

    @Basic
    private String idRef;

    @Basic
    private String name;

    @Basic
    private boolean required;

    @Basic
    private int weight;

    @Basic
    private CostFunction costFunction;

    @ManyToOne(optional = false)
    private Instance instance;

    public enum CostFunction {
        Sum,
        SumSquare,
        SquareSum,
        SumStep,
        StepSum
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CostFunction getCostFunction() {
        return costFunction;
    }

    public void setCostFunction(CostFunction costFunction) {
        this.costFunction = costFunction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public String getIdRef() {
        return idRef;
    }

    public void setIdRef(String idRef) {
        this.idRef = idRef;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Constraint");
        sb.append("{idRef='").append(idRef).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", required=").append(required);
        sb.append(", costFunction=").append(costFunction);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
