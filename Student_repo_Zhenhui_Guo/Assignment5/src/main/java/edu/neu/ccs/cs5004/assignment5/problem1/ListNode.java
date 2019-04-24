package edu.neu.ccs.cs5004.assignment5.problem1;


/**
 * Represents details of a list node in a linked list.
 */
public class ListNode {
  private Element node;
  private ListNode next;

  /**
   * Instantiates a new List.
   *
   * @param node the first
   * @param next the next
   */
  public ListNode(Element node, ListNode next) {
    this.node = node;
    this.next = next;
  }

  /**
   * Add a new node to a list.
   *
   * @param element the element
   * @return the list node
   */
  public ListNode add(Element element) {
    if (this.isEmpty()) {
      return new ListNode(element, null);
    } else {
      ListNode prev = null;
      ListNode curr = this;
      while (curr != null && curr.getNode().getPriority() > element.getPriority()) {
        prev = curr;
        curr = curr.next;
      }
      if (prev == null) {
        return new ListNode(element, this);
      } else {
        prev.next = new ListNode(element, curr);
        return this;
      }
    }
  }

  /**
   * Get the first string in a linked list.
   *
   * @return the string
   * @throws IndexOutOfRangeException the index out of range exception
   */
  public String peek() throws IndexOutOfRangeException {
    if (this.isEmpty()) {
      throw new IndexOutOfRangeException();
    } else {
      return this.node.getString();
    }
  }


  /**
   * Remove the front node in a linked list.
   *
   * @return the list node
   * @throws IndexOutOfRangeException the index out of range exception
   */
  public ListNode removeFront() throws IndexOutOfRangeException {
    if (this.isEmpty()) {
      throw new IndexOutOfRangeException();
    } else {
      return this.next;
    }
  }

  /**
   * Checks if the linked list is empty.
   *
   * @return the boolean
   */
  public boolean isEmpty() {
    return this.node == null;
  }


  /**
   * Get the node in a linked list.
   *
   * @return the node
   */
  public Element getNode() {
    return this.node;
  }

  /**
   * Get the next node in a linked list.
   *
   * @return the next
   */
  public ListNode getNext() {
    return this.next;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    ListNode listNode = (ListNode) object;

    if (getNode() != null ? !getNode().equals(listNode.getNode()) : listNode.getNode() != null) {
      return false;
    }
    return getNext() != null ? getNext().equals(listNode.getNext()) : listNode.getNext() == null;
  }

  @Override
  public int hashCode() {
    int result = getNode() != null ? getNode().hashCode() : 0;
    result = 31 * result + (getNext() != null ? getNext().hashCode() : 0);
    return result;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public Integer getSize() {
    ListNode curr = this;
    if (curr.node == null) {
      return 0;
    } else if (curr.next == null) {
      return 1;
    } else {
      return 1 + curr.next.getSize();
    }
  }
}
