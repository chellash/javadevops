package com.devops.platform;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    // getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
         this.firstName = firstName;
    }

    
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
         this.lastName = lastName;        
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
