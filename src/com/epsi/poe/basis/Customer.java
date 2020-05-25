package com.epsi.poe.basis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FR20210 on 28/10/2019.
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    private List<Film> filmsLoues;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.filmsLoues = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
