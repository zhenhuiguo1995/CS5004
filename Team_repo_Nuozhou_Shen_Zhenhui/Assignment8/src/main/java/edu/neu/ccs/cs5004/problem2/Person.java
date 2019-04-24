package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents details of a person.
 */
public class Person {

  private Name name;
  private LocalDate birthday;

  /**
   * Instantiates a new Person.
   *
   * @param name -- name of person
   * @param birthday -- birthday of the person
   */
  public Person(Name name, LocalDate birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  /**
   * Get the name.
   *
   * @return the name
   */
  public Name getName() {
    return name;
  }

  /**
   * Get the birthday.
   *
   * @return the birthday.
   */
  public LocalDate getBirthday() {
    return birthday;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Person{"
        + "name=" + name
        + ", birthday=" + birthday
        + '}';
  }

  /**
   * Check if equals.
   *
   * @param object -- to be checked object.
   * @return true if two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Person person = (Person) object;
    return Objects.equals(name, person.name) && Objects.equals(birthday, person.birthday);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, birthday);
  }
}
