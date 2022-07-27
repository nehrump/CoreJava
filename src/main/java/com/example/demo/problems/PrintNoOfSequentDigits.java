package com.example.demo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintNoOfSequentDigits {


  public static void main(String[] args) {
    System.out.println(solution(7));

  }


  /* Input value will be n , If 3, it should print previous value of 2 --> 11, No.OfCount+number=> 2(times)1 => 21
  * (i) 1 --> 1 (iValue)
2-> 11
3-> 21
4-> 1211
5->  11 12 21
6-> 31 22 11
7-> 13 11 22 21
  * */


  static String solution(int n) {

    String counterValue = "1";
    String previousValue = counterValue;

    for (int i = 2; i <= n; i++) {
      List<String> strList = prepareStringList(previousValue);
      counterValue = prepareOutput(strList); //11
      previousValue = counterValue; //11

    }

    return counterValue;

  }

  static List<String> prepareStringList(String input) { //11
    if (input.length() == 1) {
      return Collections.singletonList(input);
    }
    String[] sArray = input.split(""); //1 1
    List<String> output = new ArrayList<>();
    for (int i = 0; i < sArray.length; ) { //1
      String current = "";  //1
      int j = i;

      do {
        current = current + sArray[j]; //11
        j++;
      } while (j < sArray.length && sArray[j].equals(sArray[i]));
      i = j;

      output.add(current);


    }

    return output;


  }


  static String prepareOutput(List<String> input) {  //11 --> 21
    /*String s="";
    String s1= s.length()+String.valueOf(s.charAt(0));*/
    String output = "";
    for (String s : input) {
      output = output + s.length() + String.valueOf(s.charAt(0));
    }
    return output;

  }


}



