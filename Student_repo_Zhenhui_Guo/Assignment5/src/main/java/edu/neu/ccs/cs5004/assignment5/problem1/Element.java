package edu.neu.ccs.cs5004.assignment5.problem1;

/**
 * Represents details of an element in a priority queue, including string and priority.
 */
public class Element {
  private String string;
  private Integer priority;

  /**
   * Instantiates a new Element.
   *
   * @param string the string
   * @param priority the priority
   */
  public Element(String string, Integer priority) {
    this.string = string;
    this.priority = priority;
  }

  /**
   * Gets string.
   *
   * @return the string
   */
  public String getString() {
    return string;
  }

  /**
   * Gets priority.
   *
   * @return the priority
   */
  public Integer getPriority() {
    return priority;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Element element = (Element) object;

    if (getString() != null ? !getString().equals(element.getString())
        : element.getString() != null) {
      return false;
    }
    return getPriority() != null ? getPriority().equals(element.getPriority())
        : element.getPriority() == null;
  }

  @Override
  public int hashCode() {
    int result = getString() != null ? getString().hashCode() : 0;
    result = 31 * result + (getPriority() != null ? getPriority().hashCode() : 0);
    return result;
  }
}

