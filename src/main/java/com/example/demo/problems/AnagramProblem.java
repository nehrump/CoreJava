package com.example.demo.problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
  * Input: arr[] =  {"cat", "dog", "tac", "god", "act"};
Output: [cat, tac, act][dog, god]
  *
  * */

// cat --> c, a , t -->

//find any string starting c  , a , t-->
//
public class AnagramProblem {


  public static void main(String[] args) {

    String[] strings = new String[]{"cat", "dog", "tac", "god", "act"};
    List<String[]> anograms = findAnograms(strings);

    anograms.forEach(strings1 -> System.out.println(Arrays.toString(strings1)));

  }


  private static List<String[]> findAnograms(String[] strArray) {

    Map<String, List<String>> map = new HashMap<>();

    for (String s : strArray) {
      String[] sArray = s.split("");

      Arrays.sort(sArray);

      String key = String.join("", sArray);

      if (map.containsKey(key)) {
        List<String> l = map.get(key);
        l.add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(key, list);
      }
    }
    return map.values().stream().map(strings -> strings.toArray(new String[0]))
        .collect(Collectors.toList());
  }

}






