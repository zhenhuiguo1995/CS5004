package edu.neu.ccs.cs5004.problem1;

/**
 * Throw when the alias does not exist.
 */
public class AliasNotExistException extends RuntimeException {

  public AliasNotExistException() {
    super("The alias is not exist and the request cannot be processed.");
  }
}
