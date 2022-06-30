package co.develhope.CRUD.Entities;

import javax.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelName;
    private String type;

    public String getModelName() {
        return modelName;
    }

    public String getType() {
        return type;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
