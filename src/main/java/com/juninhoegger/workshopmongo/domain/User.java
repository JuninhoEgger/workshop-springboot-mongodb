package com.juninhoegger.workshopmongo.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static java.util.Objects.hash;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String emai;

    public User() {
    }

    public User(String id, String name, String emai) {
        this.id = id;
        this.name = name;
        this.emai = emai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return hash(id);
    }
}
