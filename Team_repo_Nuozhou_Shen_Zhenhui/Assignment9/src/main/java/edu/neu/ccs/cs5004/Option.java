package edu.neu.ccs.cs5004;

/**
 * This class represent an option.
 */
public class Option {

  private String optName;
  private String description;
  private boolean requiredArg;
  private String args;

  /**
   * Create an option.
   *
   * @param optName the option name
   * @param description the option description
   * @param requiredArg the option is required or optional
   */
  public Option(String optName, String description, boolean requiredArg) {
    this.optName = optName;
    this.description = description;
    this.requiredArg = requiredArg;
  }

  /**
   * Get the name of the option.
   *
   * @return the name
   */
  public String getOptName() {
    return optName;
  }

  /**
   * Get the description of the option.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get is the option is required.
   *
   * @return is the option is required
   */
  public boolean isRequiredArg() {
    return requiredArg;
  }

  /**
   * Get the argument of the option if it has.
   *
   * @return the argument
   */
  public String getArgs() {
    return args;
  }

  /**
   * Set the argument to the option.
   *
   * @param args the argument
   */
  public void setArgs(String args) {
    this.args = args;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Option that = (Option) obj;
    return this.getArgs().equals(that.getArgs())
        && this.getDescription().equals(that.getDescription())
        && this.getOptName().equals(that.getOptName())
        && this.isRequiredArg() == that.isRequiredArg();
  }

  @Override
  public String toString() {
    return "Option{"
        + "optName='" + optName + '\''
        + ", description='" + description + '\''
        + ", requiredArg=" + requiredArg
        + ", args='" + args + '\''
        + '}';
  }

  @Override
  public int hashCode() {
    int result = getOptName().hashCode();
    result = 31 * result + getDescription().hashCode();
    result = 31 * result + (isRequiredArg() ? 1 : 0);
    result = 31 * result + getArgs().hashCode();
    return result;
  }
}
