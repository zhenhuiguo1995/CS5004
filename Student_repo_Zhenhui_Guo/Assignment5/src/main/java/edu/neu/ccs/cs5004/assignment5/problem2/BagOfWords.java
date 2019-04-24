package edu.neu.ccs.cs5004.assignment5.problem2;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Represent details of a Bag of words.
 */
public class BagOfWords implements IBagOfWords {
  private ListNode node;

  /**
   * Instantiates a new Bag of words.
   *
   * @param node the node
   * @throws IllegalArgumentException the illegal argument exception
   */
  public BagOfWords(ListNode node) throws IllegalArgumentException {
    if (node == null) {
      throw new IllegalArgumentException();
    }
    this.node = node;
  }

  @Override
  public IBagOfWords emptyBagOfWords() {
    return new EmptyBag();
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public Integer size() {
    return this.node.getSize();
  }

  @Override
  public IBagOfWords add(String string) {
    ListNode result = new ListNode(string, this.node);
    return new BagOfWords(result);
  }

  @Override
  public boolean contains(String string) {
    ListNode curr = this.node;
    while (curr != null && !curr.getFirst().equals(string)) {
      curr = curr.getNext();
    }
    return !(curr == null);
  }

  /**
   * Gets node.
   *
   * @return the node
   */
  public ListNode getNode() {
    return node;
  }

  @Override
  public String toString() {
    return "BagOfWords{" + "node=" + node + '}';
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    BagOfWords that = (BagOfWords) object;

    HashMap<String, Integer> firstMap = new HashMap<>();
    HashMap<String, Integer> secondMap = new HashMap<>();

    ListNode curr = this.node;
    while (curr != null) {
      if (firstMap.containsKey(curr.getFirst())) {
        firstMap.put(curr.getFirst(), firstMap.get(curr.getFirst()) + 1);
      } else {
        firstMap.put(curr.getFirst(), 1);
      }
      curr = curr.getNext();
    }

    curr = that.node;
    while (curr != null) {
      if (secondMap.containsKey(curr.getFirst())) {
        secondMap.put(curr.getFirst(), secondMap.get(curr.getFirst()) + 1);
      } else {
        secondMap.put(curr.getFirst(), 1);
      }
      curr = curr.getNext();
    }

    for (Entry<String, Integer> entry: firstMap.entrySet()) {
      if (! (secondMap.containsKey(entry.getKey())
          && secondMap.get(entry.getKey()).equals(firstMap.get(entry.getKey())))) {
        return false;
      }
    }
    return true;

  }

  @Override
  public int hashCode() {
    return getNode() != null ? getNode().hashCode() : 0;
  }
}
