package edu.neu.ccs.cs5004;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
  public static void main(String args[]) {
    // first student
    String name1 = "Christina King";
    String login1 = "king.c";
    List<Integer> grades1 = new ArrayList<>();
    grades1.add(98);
    grades1.add(76);
    grades1.add(89);
    Student student1 = new Student(name1, login1, grades1);

    // second student
    String name2 = "Kidder Catherine";
    String login2 = "catherine.k";
    List<Integer> grades2 = new ArrayList<>();
    grades2.add(88);
    grades2.add(95);
    grades2.add(90);
    Student student2 = new Student(name2, login2, grades2);

    // third student
    String name3 = "Ian Gortan";
    String login3 = "gorton.ian";
    List<Integer> grades3 = new ArrayList<>();
    grades3.add(96);
    grades3.add(100);
    grades3.add(93);
    Student student3 = new Student(name3, login3, grades3);

    // add them into a list
    List<Student> courseList = new ArrayList<>();
    courseList.add(student1);
    courseList.add(student2);
    courseList.add(student3);

    /**
     * Practice problems for the first part.
     */

    // the highest grade of all students in the first course
    int highest = courseList.stream().max((a, b) -> (a.getGrades().get(0) - b.getGrades().get(0)))
        .get().getGrades().get(0);
    System.out.println(highest);

    // the highest grade of all students in the second course
    highest = courseList.stream().max((a, b) -> (a.getGrades().get(1) - b.getGrades().get(1)))
        .get().getGrades().get(1);
    System.out.println(highest);

    // the highest grade of all students in the third course
    highest = courseList.stream().max((a, b) -> (a.getGrades().get(2) - b.getGrades().get(2)))
        .get().getGrades().get(2);
    System.out.println(highest);

    // the average grade of all students in the first course
    double average1 = courseList.stream().mapToDouble(a -> a.getGrades().get(0)).sum()
        /courseList.size();
    System.out.println(average1);

    // the average grade of all students in the second course
    double average2 = courseList.stream().mapToDouble(a -> a.getGrades().get(1)).sum()
        /courseList.size();
    System.out.println(average2);

    // the average grade of all students in the third course
    double average3 = courseList.stream().mapToDouble(a -> a.getGrades().get(2)).sum()
        /courseList.size();
    System.out.println(average3);

    // the list of students with grades above average for the first course
    List<Student> list1 = courseList.stream().filter(a -> a.getGrades().get(0) > average1).collect(
        Collectors.toList());
    list1.forEach(System.out::println);

    // the list of students with grades above average for the second course
    List<Student> list2 = courseList.stream().filter(a -> a.getGrades().get(1) > average2).collect(
        Collectors.toList());
    list2.forEach(System.out::println);

    // the list of students with grades above average for the third course
    List<Student> list3 = courseList.stream().filter(a -> a.getGrades().get(2) > average3).collect(
        Collectors.toList());
    list3.forEach(System.out::println);

    // the list of students email addresses
    List<String> emailAddress = courseList.stream().map(a -> a.getLogin() + "@husky.neu.edu")
        .collect(Collectors.toList());
    emailAddress.forEach(System.out::println);

    /**
     * Practice problems for the second part-functional programming.
     */
    Function<String, String> makeEmail = s -> s + "@husky.neu.edu";
    String newEmail = makeEmail.apply(student1.getLogin());
    System.out.println(newEmail);

    Function<Student, Student> updateLogin = s -> new Student(s.getName(),
        s.getLogin() + "@husky.neu.edu", s.getGrades());
    List<Student> updatedCourse = courseList.stream().map(updateLogin::apply).
        collect(Collectors.toList());
    updatedCourse.forEach(System.out::println);

    // self-defined function -> to be continued
  }
}
