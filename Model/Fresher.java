package Model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author LENOVO
 */
public class Fresher extends Candidate {

    private LocalDate graduateDate;
    private String rankOfGraduation;
    private String education;

    public Fresher(String id, String firstName, String lastName, LocalDate birthdate, String phone, String email, String address, int candidateType, LocalDate graduateDate, String rankOfGraduation, String education) {
        super(id, firstName, lastName, birthdate, phone, email, address, candidateType);
        this.graduateDate = graduateDate;
        this.rankOfGraduation = rankOfGraduation;
        this.education = education;
    }

    public LocalDate getGraduateDate() {
        return graduateDate;
    }

    public String getRankOfGraduation() {
        return rankOfGraduation;
    }

    public String getEducation() {
        return education;
    }

    public void setGraduateDate(LocalDate graduateDate) {
        this.graduateDate = graduateDate;
    }

    public void setRankOfGraduation(String rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("d/M/uuuu");
        String dateFormat = graduateDate.format(fm);
        return super.toString() + " | " + dateFormat + " | " + rankOfGraduation + " | " + education;
    }

}
