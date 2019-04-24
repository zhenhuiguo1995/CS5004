package edu.neu.ccs.cs5004.Summer2016Final;

/*public class ParentBinaryTree<T> implements IParentBinaryTree<T> {
  private Node<T> root;*/

/*
  public ParentBinaryTree(T value) {
    this.root = new Node<>(value, null, null, null);
  }


*/
/*  @Override
  public Integer edgesToRoot(T value) {
    if (noTree() || root.isEmpty()) {
      throw new IllegalArgumentException("Empty parent binary tree");
    } else if (root.contains(value)) {
      return root.getNumberOfEdgesToRoot(value);
    } else {
      throw new IllegalArgumentException("PBT must contain value");
    }
  }

  private boolean noTree() {
    return root == null;
  }

  @Override
  public void add(T value) {
    if (noTree()) {
      root = new Node<T>(value, null, null, null);
    } else if (root.contains(value)) {
      return;
    } else {
      root.addNewNode(value);
    }

  }

  @Override
  public void remove(T value) {
    if (noTree() || root.isEmpty() || root.contains(value)) {
      return;
    } else if (root.getCurr().equals(value)) {
      if (root.isLeaf()) {
        root.setVal(null);
      } else if (root.isEmptyLeft()) {
        root = root.getRight();
      } else if (root.isEmptyRight()) {
        root = root.getLeft();
      } else {
        Node<T> oldRight = root.getRight();
        root = root.getLeft();
        root.setParent(null);
        root.addToRightMost(oldRight);
      }
    } else {
      root.removeValue(value);
    }
  }*//*

}
*/
