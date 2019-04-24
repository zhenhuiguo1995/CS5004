package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private Person firstPerson;
  private Person secondPerson;
  private Actor firstActor;
  private Actor secondActor;

  @Before
  public void setUp() throws Exception {
    this.firstPerson = new Person(20, "Sansa");
    this.secondPerson = new Person(23, "Rob");
    this.firstActor = new Actor(37, "Cersi", 10);
    this.secondActor = new Actor(12,  "Tomman", 3);
  }

  @Test
  public void compareTo() throws Exception {
    assertEquals(-3, this.firstPerson.compareTo(this.secondPerson));
    PriorityQueue<Person> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(this.firstActor);
    priorityQueue.offer(this.secondActor);
    priorityQueue.offer(this.firstPerson);
    priorityQueue.offer(this.secondPerson);
    assertSame(this.secondActor, priorityQueue.poll());
    assertSame(this.firstPerson, priorityQueue.poll());
    assertSame(this.secondPerson, priorityQueue.poll());
    assertSame(this.firstActor, priorityQueue.poll());
  }

  @Test
  public void compare() throws Exception {
    assertEquals(7, this.firstPerson.compare(this.firstActor, this.secondActor));
  }

  @Test
  public void reverse() throws Exception {
    PriorityQueue<Person> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    priorityQueue.offer(this.firstActor);
    priorityQueue.offer(this.secondActor);
    priorityQueue.offer(this.firstPerson);
    priorityQueue.offer(this.secondPerson);
    assertSame(this.firstActor, priorityQueue.poll());
    assertSame(this.secondPerson, priorityQueue.poll());
    assertSame(this.firstPerson, priorityQueue.poll());
    assertSame(this.secondActor, priorityQueue.poll());
  }

/* change compareTo method in Person
  @Test
  public void reverseCompareTo() throws Exception {
    PriorityQueue<Person> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(this.firstActor);
    priorityQueue.offer(this.secondActor);
    priorityQueue.offer(this.firstPerson);
    priorityQueue.offer(this.secondPerson);
    assertSame(this.firstActor, priorityQueue.poll());
    assertSame(this.secondPerson, priorityQueue.poll());
    assertSame(this.firstPerson, priorityQueue.poll());
    assertSame(this.secondActor, priorityQueue.poll());
  }*/


}