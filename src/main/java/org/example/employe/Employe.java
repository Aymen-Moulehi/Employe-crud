package org.example.employe;

import java.io.Serializable;
import java.util.Objects;

public class Employe{
    private Integer id;
    private String firstName;
    private String lastName;

    public Employe(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employe(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id == employe.id && Objects.equals(firstName, employe.firstName) && Objects.equals(lastName, employe.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
