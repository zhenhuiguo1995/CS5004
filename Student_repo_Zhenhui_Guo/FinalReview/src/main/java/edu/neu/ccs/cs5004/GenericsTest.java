package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
  public static void main(String[] args) {
    List list = new ArrayList();
    list.add("a");
    list.add(100);
    list.stream().forEach(System.out::println);
  }

  /*public static void main1(String[] args) {
    List<String> list = new ArrayList();
    list.add("a");
    list.add(100);
    list.stream().forEach(System.out::println);
  }
*/
}
