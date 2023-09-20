package Model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Experience extends Candidate {
    private int expInYear;
    private ArrayList<String> proSkill;

    
    public Experience(String id, String firstName, String lastName, LocalDate birthdate, String phone, String email, String address, int candidateType, int expInYear, ArrayList<String> proSkill) {
        super(id, firstName, lastName, birthdate, phone, email, address, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public ArrayList getProSkill() {
        return proSkill;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill.add(proSkill);
    }

    @Override
    public String toString() {
        StringBuilder skillBuilder = new StringBuilder();
        for(String skill : proSkill){
            skillBuilder.append(skill).append(", ");
        }
        
        if(!proSkill.isEmpty()){
            skillBuilder.setLength(skillBuilder.length() - 2);
        }
        return super.toString()+" | "+ expInYear +" | "+skillBuilder;
    }
    
}
