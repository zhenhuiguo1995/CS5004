package edu.neu.ccs.cs5004.assignment5.problem2;

/**
 * Represents details of the interface Bag of words.
 */
public interface IBagOfWords {

  /**
   * Creates an empty bag of words.
   *
   * @return the bag of words
   */
  IBagOfWords emptyBagOfWords();

  /**
   * Indicates if the bag of words is empty or not.
   *
   * @return the boolean
   */
  boolean isEmpty();

  /**
   * Returns the size of the bag of words data collection.
   *
   * @return the integer
   */
  Integer size();

  /**
   * Add a string to the bag of words.
   *
   * @param string the string to be added
   * @return the bag of words
   */
  IBagOfWords add(String string);

  /**
   * Checks if a string is in the bag of words.
   *
   * @param string the s to check
   * @return the boolean
   */
  boolean contains(String string);
}
