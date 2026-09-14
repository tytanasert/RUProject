/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;
import java.io.*;
/**
 *
 * @author ty
 */
public class exStringInput {

    public static void main(String args[]) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(reader);
        String Input = "";
        System.out.println("Input String :");
        Input = stdin.readLine();
        System.out.println("Your input :"+Input);
    }
}
