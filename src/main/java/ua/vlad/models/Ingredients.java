package ua.vlad.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Ingredient")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

//    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false)
    private String name;

    public Ingredients() {
    }

    public Ingredients(String name) {
        this.name = name;
    }

    // getters & setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
