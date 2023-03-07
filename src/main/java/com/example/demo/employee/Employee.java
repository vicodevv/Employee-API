package com.example.demo.employee;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"

    )
    private Long id;
    private String firstName;
    private String lastName;
    private String positionHeld;
    private String gender;
    private LocalDate dob;
    private String email;

    public Employee(){

    } 
    public Employee(Long id, String firstName, String lastName, String positionHeld, String gender, LocalDate dob, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionHeld = positionHeld;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
    }
    public Employee(String firstName, String lastName, String positionHeld, String gender, LocalDate dob, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionHeld = positionHeld;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
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

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        this.positionHeld = positionHeld;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
