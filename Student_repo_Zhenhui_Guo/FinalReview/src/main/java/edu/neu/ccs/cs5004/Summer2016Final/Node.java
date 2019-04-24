package edu.neu.ccs.cs5004.Summer2016Final;

import java.awt.DisplayMode;

public class Node<T> {
  private T curr;
  private Node<T> left;
  private Node<T> right;
  private Node<T> parent;

  public Node(T curr, Node<T> left, Node<T> right, Node<T> parent) {
    this.curr = curr;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }

  // indicates if a tree is an empty tree
  public boolean isEmpty() {
    return curr == null && left == null
        && right == null && parent == null;
  }

  public boolean contains(T value) {
    if (curr == null) {
      return false;
    } else if (curr.equals(value)) {
      return true;
    } else {
      return left.contains(value) || right.contains(value);
    }
  }

  // requires root.contains(value) is true
/*
  public Integer getNumberOfEdgesToRoot(T value) {
    if (curr.equals(value)) {
      return
    }
  }
*/

  public boolean isEmptyLeft() {
    return this.left == null;
  }


  public boolean isEmptyRight() {
    return this.right == null;
  }

  public Node<T> getRight() {
    return right;
  }

  public Node<T> getLeft() {
    return left;
  }

  public boolean isLeaf() {
    return isEmptyLeft() && isEmptyRight() && curr != null;
  }

  public T getCurr() {
    return curr;
  }
}
