package edu.neu.ccs.cs5004.Spring2018Final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstProblem {
  public static void main(String[] args) {
    List<String> listChars = new ArrayList<>();
    listChars.add("D");
    listChars.add("D");
    listChars.add("E");
    listChars.add("T");
    listChars.add("B");
    System.out.println(listChars);
    System.out.println(listChars.stream().collect(Collectors.joining("-")));
    String[] myArray = { "this", "is", "a", "sentence" };
    System.out.println(Arrays.stream(myArray).reduce("", (a,b) -> a + " " + b));

    List<Integer> ratio = new ArrayList<>();
    ratio.add(3);
    ratio.add(5);
    ratio.add(3);
    ratio.add(2);
    // reduce provides a base on which we perform the opeations with
    // 2 - 3 - 5 - 3 - 2 = -11
    System.out.println("Total exam points: " +ratio.stream().reduce(2, (a, b) -> a-b));

    // 2*3*5*3*2 = 180
    System.out.println("Total exam points: " +ratio.stream().reduce(2, (a, b) -> a*b));


  }

}
