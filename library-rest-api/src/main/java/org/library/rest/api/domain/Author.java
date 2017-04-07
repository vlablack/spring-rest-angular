package org.library.rest.api.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Authors")
public class Author implements Serializable {

    private static final long serialVersionUID = -416053639940575453L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Length(max = 50)
    private String firstName;

    @NotNull
    @Length(max = 50)
    private String lastName;

    public Author() {

    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
