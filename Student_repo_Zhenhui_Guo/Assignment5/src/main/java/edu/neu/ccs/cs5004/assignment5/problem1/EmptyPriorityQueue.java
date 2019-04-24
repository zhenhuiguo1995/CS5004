package edu.neu.ccs.cs5004.assignment5.problem1;

/**
 * Represents an empty priority queue.
 */
public class EmptyPriorityQueue implements IPriorityQueue {
  private ListNode head;

  /**
   * Gets head.
   *
   * @return the head
   */
  public ListNode getHead() {
    return head;
  }

  /**
   * Instantiates a new Empty priority queue.
   */
  public EmptyPriorityQueue() {
    this.head = null;
  }

  @Override
  public IPriorityQueue createEmpty() {
    return new EmptyPriorityQueue();
  }

  @Override
  public IPriorityQueue add(Integer priority, String string) {
    return new PriorityQueue(new ListNode(new Element(string, priority), null));
  }

  @Override
  public String peek() throws IndexOutOfRangeException {
    throw new IndexOutOfRangeException();
  }

  @Override
  public IPriorityQueue pop() throws IndexOutOfRangeException {
    throw new IndexOutOfRangeException();
  }

  @Override
  public boolean isEmpty() {
    return true;
  }


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    EmptyPriorityQueue that = (EmptyPriorityQueue) object;

    return head != null ? head.equals(that.head) : that.head == null;
  }

  @Override
  public int hashCode() {
    return head != null ? head.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "EmptyPriorityQueue{" + "head=" + head + '}';
  }
}
