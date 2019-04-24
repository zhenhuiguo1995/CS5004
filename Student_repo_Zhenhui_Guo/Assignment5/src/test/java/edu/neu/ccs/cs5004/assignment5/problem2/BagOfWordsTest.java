package edu.neu.ccs.cs5004.assignment5.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {
  private BagOfWords bagOfWords;
  private ListNode node;
  private String first;
  private ListNode next;
  private EmptyBag emptyBag;

  @Before
  public void setUp() throws Exception {
    this.first = "hello world";
    this.next = null;
    this.node = new ListNode(this.first, this.next);
    this.bagOfWords = new BagOfWords(this.node);
    this.emptyBag = new EmptyBag();
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalConstructor() throws IllegalArgumentException {
    this.bagOfWords = new BagOfWords(null);
  }

  @Test
  public void emptyBagOfWords() throws Exception {
    EmptyBag e = (EmptyBag) this.emptyBag.emptyBagOfWords();
    assertNull(e.getNode());
  }

  @Test
  public void emptyBagOfWordsFromBag() throws Exception {
    EmptyBag test = (EmptyBag) this.bagOfWords.emptyBagOfWords();
    assertNull(test.getNode());
  }


  @Test
  public void isEmpty() throws Exception {
    assertFalse(this.bagOfWords.isEmpty());
    assertTrue(this.emptyBag.isEmpty());
  }

  @Test
  public void size() throws Exception {
    assertSame(1, this.bagOfWords.size());
  }

  @Test
  public void addVoid() throws Exception {
    String temp = "World cup";
    BagOfWords bag = (BagOfWords) this.emptyBag.add(temp);
    assertEquals(temp, bag.getNode().getFirst());
    assertNull(bag.getNode().getNext());
  }

  @Test
  public void add() throws Exception {
    String temp = "World cup";
    BagOfWords bag =  (BagOfWords) this.bagOfWords.add(temp);
    assertEquals(temp, bag.getNode().getFirst());
    assertEquals(this.first, bag.getNode().getNext().getFirst());
  }


  @Test
  public void contains() throws Exception {
    assertTrue(this.bagOfWords.contains(this.first));
  }

  @Test
  public void notContains() throws Exception {
    assertFalse(this.bagOfWords.contains("Interesting"));
  }

  @Test
  public void getNode() throws Exception {
    assertEquals(this.node, this.bagOfWords.getNode());
  }


  @Test
  public void equalsSame() throws Exception {
    assertTrue(this.bagOfWords.equals(this.bagOfWords));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.bagOfWords.equals(null));
  }

  @Test
  public void equalsDifferentClass() throws Exception {
    assertFalse(this.bagOfWords.equals(new ListNode(null, null)));
  }

  @Test
  public void equalsAnotherBag() throws Exception {
    assertTrue(this.bagOfWords.equals(new BagOfWords(this.node)));
  }

  @Test
  public void equalsDifferentWords() throws Exception {
    BagOfWords firstBagOfWords = (BagOfWords) this.bagOfWords.add("a");
    firstBagOfWords = (BagOfWords) firstBagOfWords.add("b");

    BagOfWords secondBagOfWords = new BagOfWords(new ListNode("a", null));
    assertNotEquals(firstBagOfWords, secondBagOfWords);
   }

  @Test
  public void equalsDifferentCounts() throws Exception {
    BagOfWords firstBagOfWords = (BagOfWords) this.bagOfWords.add("b");
    BagOfWords secondBagOfWords = new BagOfWords(new ListNode("b", null));
    secondBagOfWords = (BagOfWords) secondBagOfWords.add(this.first);
    secondBagOfWords = (BagOfWords) secondBagOfWords.add("b");
    assertNotEquals(firstBagOfWords, secondBagOfWords);
  }

  @Test
  public void equals() throws Exception {
    BagOfWords firstBagOfWords = (BagOfWords) this.bagOfWords.add("b");
    firstBagOfWords = (BagOfWords) firstBagOfWords.add("b");

    BagOfWords secondBagOfWords = new BagOfWords(new ListNode("b", null));
    secondBagOfWords = (BagOfWords) secondBagOfWords.add(this.first);
    secondBagOfWords = (BagOfWords) secondBagOfWords.add("b");
    assertEquals(firstBagOfWords, secondBagOfWords);
  }


}