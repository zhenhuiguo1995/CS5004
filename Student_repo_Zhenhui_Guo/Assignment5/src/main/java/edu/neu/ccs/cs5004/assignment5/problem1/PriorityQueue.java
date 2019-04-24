package edu.neu.ccs.cs5004.assignment5.problem1;

/**
 * Represents an array list based priority queue.
 */
public class PriorityQueue implements IPriorityQueue {
  private ListNode head;

  /**
   * Instantiates a new Priority queue.
   *
   * @param head the head
   * @throws IllegalArgumentException the illegal argument exception
   */
  public PriorityQueue(ListNode head) throws IllegalArgumentException {
    if (head == null) {
      throw new IllegalArgumentException();
    }
    this.head = head;
  }

  @Override
  public IPriorityQueue createEmpty() {
    return new EmptyPriorityQueue();
  }

  @Override
  public IPriorityQueue add(Integer priority, String string) {
    return new PriorityQueue(this.head.add(new Element(string, priority)));
  }

  @Override
  public String peek() throws IndexOutOfRangeException {
    return this.head.getNode().getString();
  }

  @Override
  public IPriorityQueue pop() throws IndexOutOfRangeException {
    ListNode curr = this.head.removeFront();
    if (curr == null) {
      return new EmptyPriorityQueue();
    } else {
      return new PriorityQueue(curr);
    }
  }

  @Override
  public boolean isEmpty() {
    return false;
  }


  @Override
  public String toString() {
    return "PriorityQueue{" + "head=" + head + '}';
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || this.getClass() != object.getClass()) {
      return false;
    }

    PriorityQueue that = (PriorityQueue) object;

    return this.head.equals(that.head);
  }

  @Override
  public int hashCode() {
    return head != null ? head.hashCode() : 0;
  }

  /**
   * Gets head.
   *
   * @return the head
   */
  public ListNode getHead() {
    return head;
  }
}
