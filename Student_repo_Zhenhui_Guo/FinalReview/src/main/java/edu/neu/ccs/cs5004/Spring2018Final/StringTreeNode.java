package edu.neu.ccs.cs5004.Spring2018Final;

public class StringTreeNode {
  public String data;
  public StringTreeNode left;
  public StringTreeNode right;

  public StringTreeNode(String data, StringTreeNode left, StringTreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public StringTreeNode(String data) {
    this(data, null, null);
  }

  public String getData() {
    return this.data;
  }

  public StringTreeNode getLeft () {
    return this.left;
  }

  public StringTreeNode getRight () {
    return this.right;
  }

  public boolean isEmpty () {
    return !(this.data.isEmpty() && this.left.isEmpty() && this.right.isEmpty());
  }
}
