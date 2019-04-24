package edu.neu.ccs.cs5004;

import java.util.List;
import java.util.Objects;

/**
 * Adapted from:
 * Created by therapon on 7/11/16.
 */
public class Student {
  private String name;
  private String login;
  private List<Integer> grades;

  public Student(String name, String login, List<Integer> grades) {
    this.name = name;
    this.login = login;
    this.grades = grades;
  }

  /**
   * Getter for property 'name'.
   *
   * @return Value for property 'name'.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for property 'name'.
   *
   * @param name Value to set for property 'name'.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for property 'login'.
   *
   * @return Value for property 'login'.
   */
  public String getLogin() {
    return login;
  }

  /**
   * Setter for property 'login'.
   *
   * @param login Value to set for property 'login'.
   */
  public void setLogin(String login) {
    this.login = login;
  }

  /**
   * Getter for property 'grades'.
   *
   * @return Value for property 'grades'.
   */
  public List<Integer> getGrades() {
    return grades;
  }

  /**
   * Setter for property 'grades'.
   *
   * @param grades Value to set for property 'grades'.
   */
  public void setGrades(List<Integer> grades) {
    this.grades = grades;
  }



  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Student student = (Student) other;
    return Objects.equals(name, student.name)
        && Objects.equals(login, student.login)
        && Objects.equals(grades, student.grades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, login, grades);
  }

  @Override
  public String toString() {
    return "Student{"
        + "name='" + name + '\''
        + ", login='" + login + '\''
        + ", grades=" + grades
        + '}';
  }
}
