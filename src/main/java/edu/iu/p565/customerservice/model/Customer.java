package edu.iu.p565.customerservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class Customer {
    private int id;
    @NotEmpty(message = "Name cannot be empty.")
    private String name;
    @NotEmpty(message = "Email cannot be empty.")
    private String email;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}