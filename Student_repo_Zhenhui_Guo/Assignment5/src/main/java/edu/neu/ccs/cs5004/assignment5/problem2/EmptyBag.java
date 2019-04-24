package edu.neu.ccs.cs5004.assignment5.problem2;

/**
 * Represents details of an empty bag of words.
 */
public class EmptyBag implements IBagOfWords {
  private ListNode node;

  /**
   * Instantiates a new Empty bag.
   */
  public EmptyBag() {
    this.node = null;
  }

  @Override
  public IBagOfWords emptyBagOfWords() {
    return new EmptyBag();
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public IBagOfWords add(String string) {
    return new BagOfWords(new ListNode(string, null));
  }

  @Override
  public boolean contains(String string) {
    return false;
  }

  /**
   * Gets node.
   *
   * @return the node
   */
  public ListNode getNode() {
    return null;
  }

  @Override
  public String toString() {
    return "EmptyBag{" + "node=" + node + '}';
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    EmptyBag emptyBag = (EmptyBag) object;

    return getNode() != null ? getNode().equals(emptyBag.getNode()) : emptyBag.getNode() == null;
  }

  @Override
  public int hashCode() {
    return getNode() != null ? getNode().hashCode() : 0;
  }
}
