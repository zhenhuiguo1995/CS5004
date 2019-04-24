package edu.neu.ccs.cs5004;

/**
 * Thrown when the template type is different from the notice type.
 */
public class WrongTemplateTypeException extends RuntimeException {

  public WrongTemplateTypeException() {
    super("The template type is wrong.");
  }
}
