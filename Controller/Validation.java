/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dai Nhan
 */
public class Validation {

    public LocalDate checkDate(String birthDate) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/uuuu");
            LocalDate date = LocalDate.parse(birthDate, dateFormatter);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public String checkPhone(String phone) {
        if (phone.length() < 10 || phone.length() > 15) {
            return null;
        }
        String pattern = "^[0-9]+$";
        if (phone.matches(pattern) && phone.startsWith("09")) {
            return phone;
        }
        return phone;
    }

    public boolean checkYearExperience(int yearExperience) {
        return yearExperience < 100 && yearExperience > 0;
    }

    public String checkRank(String rank) {
        String trim = rank.toLowerCase().trim();
        if (trim.equals("excellence") || trim.equals("good") || trim.equals("fair") || trim.equals("poor")) {
            return rank;
        }
        return null;
    }

    public String checkmail( String mail){
         if(mail.contains("@gmail.com")){
             return mail;
         }
         return null;
    }
}
