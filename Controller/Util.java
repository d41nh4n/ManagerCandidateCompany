/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Candidate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dai Nhan
 */
public class Util {

    public Util() {
 
    }

    public String getInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    public void display(String message) {
        System.out.println(message);
    }

}
