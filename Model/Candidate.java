/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dai Nhan
 */
public class Candidate {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private int candidateType;

    public Candidate(String id, String firstName, String lastName, LocalDate birthdate, String phone, String email, String address, int candidateType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.candidateType = candidateType;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email + "@gmail.com";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("d/M/uuuu");
        String dateFormat = birthdate.format(fm);
        return id + " | " + firstName + " " + lastName + " | " + dateFormat + " | " + address + " | " + phone + " | " + email;
    }
}
