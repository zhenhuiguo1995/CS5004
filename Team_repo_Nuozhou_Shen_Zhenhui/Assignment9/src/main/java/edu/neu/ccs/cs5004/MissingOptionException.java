package edu.neu.ccs.cs5004;

/**
 * Thrown when an option is missing.
 */
public class MissingOptionException extends RuntimeException {

  public MissingOptionException() {
    super("Miss option.");
  }
}
