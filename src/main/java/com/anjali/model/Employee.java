package com.anjali.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.*;

/**
 * Employee has 3 fields -> id, name and role
 * Employee Table
 * | id | name | role
 * | 1 | ABC  | HR
 * | 2 | XYZ | Admin
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Employee {
private @Id
    @GeneratedValue Long id;
private String name;
private String role;
private String firstName;
private String lastName;
    public Employee( String firstName, String lastName, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
public String getName(){
        return firstName + " " + lastName;
}

public void setName(){
        String[] firstNameAndLastname = name.split(" ");

        this.firstName = firstNameAndLastname[0];
        this.lastName = firstNameAndLastname[1];

}
}
