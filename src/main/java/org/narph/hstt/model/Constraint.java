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
    @GeneratedValue
    private int id;

    private String name;
    private boolean required;
    private int weight;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
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



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Constraint");
        sb.append("{costFunction=").append(costFunction);
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", required=").append(required);
        sb.append(", weight=").append(weight);
        sb.append(", instance=").append(instance);
        sb.append('}');
        return sb.toString();
    }
}
