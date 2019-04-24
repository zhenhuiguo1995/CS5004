package edu.neu.ccs.cs5004.assignment5.problem1;


/**
 * Represents the interface of a Priority queue.
 */
public interface IPriorityQueue {

  /**
   * Create an empty priority queue.
   *
   * @return the empty priority queue
   */
  IPriorityQueue createEmpty();

  /**
   * Add an element to a priority queue.
   *
   * @param priority the priority of the string
   * @param string the string
   * @return a new priority queue
   */
  IPriorityQueue add(Integer priority, String string);

  /**
   * Returns the peek string in the priority queue.
   *
   * @return the string
   * @throws IndexOutOfRangeException the index out of range exception
   */
  String peek() throws IndexOutOfRangeException;

  /**
   * Pops out the peek element from priority queue.
   *
   * @return the new priority queue
   * @throws IndexOutOfRangeException the index out of range exception
   */
  IPriorityQueue pop() throws IndexOutOfRangeException;

  /**
   * Indicates if the priority queue is empty or not.
   *
   * @return the boolean
   */
  boolean isEmpty();

}
