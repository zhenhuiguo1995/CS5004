package edu.neu.ccs.cs5004;

/**
 * Thrown when an argument is missing.
 */
public class MissingArgumentException extends RuntimeException {

  public MissingArgumentException() {
    super("Miss argument.");
  }
}
