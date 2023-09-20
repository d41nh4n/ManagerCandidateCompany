package Model;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dai Nhan
 */
public class Intern extends Candidate {

    private String major;
    private String semster;
    private String universityName;

    public Intern(String id, String firstName, String lastName, LocalDate birthdate, String phone, String email, String address, int candidateType, String major, String semster, String universityName) {
        super(id, firstName, lastName, birthdate, phone, email, address, candidateType);
        this.major = major;
        this.semster = semster;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public String getSemster() {
        return semster;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemster(String semster) {
        this.semster = semster;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString()+" | "+ major +" | "+ semster +" | "+ universityName;
    }

}
