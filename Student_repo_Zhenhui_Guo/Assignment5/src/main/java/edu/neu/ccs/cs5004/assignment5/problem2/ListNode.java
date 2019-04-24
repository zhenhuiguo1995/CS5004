package edu.neu.ccs.cs5004.assignment5.problem2;

/**
 * Represent details of a List node.
 */
public class ListNode {
  private String first;
  private ListNode next;

  /**
   * Instantiates a new List node.
   *
   * @param first the first
   * @param next the next
   */
  public ListNode(String first, ListNode next) {
    this.first = first;
    this.next = next;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public int getSize() {
    if (this.first == null) {
      return 0;
    } else if (this.next == null) {
      return 1;
    } else {
      return 1 + this.next.getSize();
    }
  }

  /**
   * Gets first.
   *
   * @return the first
   */
  public String getFirst() {
    return first;
  }

  /**
   * Gets next.
   *
   * @return the next
   */
  public ListNode getNext() {
    return next;
  }
}
