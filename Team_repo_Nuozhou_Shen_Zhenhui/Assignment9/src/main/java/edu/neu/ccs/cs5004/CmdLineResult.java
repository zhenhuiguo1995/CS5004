package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;

/**
 * This is class represents the result of command line parser.
 */
public class CmdLineResult {

  /**
   * The number of required options.
   */
  private static final int NUM_OF_OPTIONS = 4;
  private String type;
  private Map<String, Option> options = new HashMap<>();

  /**
   * Get the options of the command.
   *
   * @return the options
   */
  public Map<String, Option> getOptions() {
    return options;
  }

  /**
   * Get the type of the notice.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Add a option to the result. Set the type if the option is the type option.
   *
   * @param opt the new option
   */
  public void addOption(Option opt) {
    if (opt.getOptName().matches(Options.PRODUCT_PATTERN)) {
      setType(opt.getOptName().substring(2));
    }
    options.put(opt.getOptName(), opt);
  }

  /**
   * Set the type of the notice.
   *
   * @param type the type of the notice
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * check: 1.no options missing. 2.no args missing. 3.consistent type.
   */
  public void checkValidity() {
    if (options.size() != NUM_OF_OPTIONS) {
      System.out.println("Options missing.");
      throw new MissingOptionException();
    }
    boolean isMissingArgs = options.entrySet().stream()
        .filter(entry -> entry.getValue().isRequiredArg())
        .anyMatch(entry -> entry.getValue().getArgs() == null);
    if (isMissingArgs) {
      System.out.println("Arguments missing.");
      throw new MissingArgumentException();
    }
    if (!isTypeConsistent()) {
      System.out.println("The template type is wrong.");
      throw new WrongTemplateTypeException();
    }
  }

  /**
   * Helper method to check to type consistency.
   *
   * @return true if the options are consistent in terms of the type
   */
  private boolean isTypeConsistent() {
    if (type.equals(Options.EMAIL)) {
      return options.containsKey(Options.EMAIL_TEMPLATE);
    } else {
      return options.containsKey(Options.LETTER_TEMPLATE);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    CmdLineResult that = (CmdLineResult) obj;
    return this.getOptions().equals(that.getOptions())
        && this.getType().equals(that.getType());
  }

  @Override
  public String toString() {
    return "CmdLineResult{"
        + "type='" + type + '\''
        + ", options=" + options
        + '}';
  }

  @Override
  public int hashCode() {
    int result = getType().hashCode();
    result = 31 * result + getOptions().hashCode();
    return result;
  }
}
