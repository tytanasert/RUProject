/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MMP.HP;

//import rearach60.mp.*;
//import ddmfinal.AhoCorasick.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class createText {
    
        public static String GenerateText(String Filename) throws IOException{
        File fos;
        FileReader fileReader;
        BufferedReader reader;   
        String st="";
        long te=0,tb=0;
       try{
           //Filename="c:\\gbcon120.seq";
          // Filename="C:\\PhDResearches\\StringExperiment60\\src\\stringexperiment60\\text2\\text1024_1.txt";
        fos = new File(Filename);
        fileReader= new FileReader(fos);
        reader = new BufferedReader(fileReader);  
        //text = new char[size];
        int count = 0;
        tb=System.nanoTime();
        while(count<10){
            st=st+reader.readLine();//value[count];
               count++;
        }
        te=System.nanoTime();
        fileReader.close();
        System.out.println("อ่านแฟ้ม OK"+st);
       }catch(java.lang.Exception e) {}
        return st;
    } 
        
       public static String[] getPatternText(String Filename, int leng) throws IOException{
        File fos;
        FileReader fileReader;
        BufferedReader reader;   
        String st[]=new String[leng];
        long te=0,tb=0;
       try{
           System.out.println(Filename);
           //Filename="c:\\gbcon120.seq";
           //Filename="C:\\PhDResearches\\StringExperiment60\\src\\stringexperiment60\\text2\\text1024_1.txt";
           //Filename="C:\\PhDResearches\\StringExperiment60\\src\\stringexperiment60\\text2\\text1024_1.txt";
        fos = new File(Filename);
        fileReader= new FileReader(fos);
        reader = new BufferedReader(fileReader);  
        //text = new char[size];
        int i=0;
        while(i<leng){
            st[i]=reader.readLine();//value[count];       
            i++;
        }

        fileReader.close();
        System.out.println("อ่านแฟ้ม Pattern OK:");

       }catch(java.lang.Exception e) {}
        return st;
    } 
    
}
