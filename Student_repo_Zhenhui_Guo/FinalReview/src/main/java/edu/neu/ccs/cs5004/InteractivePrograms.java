package edu.neu.ccs.cs5004;

import java.util.Scanner;

public class InteractivePrograms {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.println("How many course are you taking this semester?");
    int numCourses = console.nextInt();

    System.out.println(numCourses + "....That's a lot!");
    System.exit(0);
  }

}
