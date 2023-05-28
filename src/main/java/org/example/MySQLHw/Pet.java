package org.example.MySQLHw;

import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1l;
    int id;
    String animal;
    int age;

    public Pet() {
    }

    public Pet(String animal, int age) {
        this.animal = animal;
        this.age = age;
    }

    public Pet(int id, String animal, int age) {
        this.id = id;
        this.animal = animal;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPet() {
        return animal;
    }

    public void setPet(String animal) {
        this.animal = animal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
