package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a set of optionsMap.
 */
public class Options {

  static final String PRODUCT_PATTERN = "--([a-z]*)$";
  static final String EMAIL_TEMPLATE = "--email-template";
  static final String LETTER_TEMPLATE = "--letter-template";
  static final String EMAIL = "email";
  static final String LETTER = "letter";

  private Map<String, Option> optionsMap = new HashMap<>();

  /**
   * Add an option to the set of optionsMap.
   *
   * @param option the new option
   * @return the set of optionsMap
   */
  public Options addOptions(Option option) {
    String key = option.getOptName();
    optionsMap.put(key, option);
    return this;
  }

  /**
   * Get the set of optionsMap.
   *
   * @return the set of option
   */
  public Map<String, Option> getOptionsMap() {
    return optionsMap;
  }

  /**
   * Check if the given option is in the set of optionsMap.
   *
   * @param optName the option name to be checked
   * @return if the given option is in the set of optionsMap
   */
  public boolean hasOptions(String optName) {
    return optionsMap.containsKey(optName);
  }

  @Override
  public String toString() {
    final StringBuilder buf = new StringBuilder();

    buf.append("[ Options: ");
    buf.append(optionsMap.toString());
    buf.append(" ]");
    buf.append("[ Required Options: ");
    buf.append(" ]");

    return buf.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Options options = (Options) object;

    return getOptionsMap().equals(options.getOptionsMap());
  }

  @Override
  public int hashCode() {
    return getOptionsMap().hashCode();
  }
}
