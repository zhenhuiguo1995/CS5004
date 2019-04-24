package edu.neu.ccs.cs5004;

/**
 * Thrown when the option is unrecognized.
 */
public class UnrecognizedOptionException extends RuntimeException {

  public UnrecognizedOptionException() {
    super("Unrecognized Option!");
  }
}
