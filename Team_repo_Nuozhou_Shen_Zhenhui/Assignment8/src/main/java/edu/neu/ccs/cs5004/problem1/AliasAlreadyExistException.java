package edu.neu.ccs.cs5004.problem1;

/**
 * Thrown when the alias is already existed.
 */
public class AliasAlreadyExistException extends RuntimeException {

  public AliasAlreadyExistException() {
    super("The alias is already existed.");
  }
}
