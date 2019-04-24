package edu.neu.ccs.cs5004;

import java.util.Comparator;

public class Person implements Comparable<Person>, Comparator<Actor> {
  protected int age;
  protected String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  // Comparable -> compareTo
  @Override
  public int compareTo(Person person) {
    return (this.age - person.age);
  }

  // Comparator -> compare
  @Override
  public int compare(Actor actor, Actor object) {
    return actor.actingYears - object.actingYears;
  }
}
