package com.rau.linecorp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] arg) throws Exception {

       String max = "-1";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String wend = br.readLine();
        String Wstart = "0";
        
       //Time Complexity O(n) 
       while(true) {
           String input = br.readLine();
           if (input.trim().equals(""))
               break;

           if (Wstart.compareTo(wend) <0) {
               if (input.compareTo(max) > 0) {
                   max = input;
               }
               Wstart = add1(Wstart);
           } else {
               if (input.compareTo(max) > 0) {
                   max = input;
               }
           }

           System.out.println(max);
       }
    }

    public static String add1(String str) {
        double f= Double.parseDouble(str);
        f = f+1;
        return String.valueOf(f);
    }
}