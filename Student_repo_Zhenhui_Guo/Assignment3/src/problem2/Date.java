package problem2;

/**
 * Represents information of a date.
 */
public class Date {
  private MONTH month;
  private Integer year;

  /**
   * Creates a date.
   *
   * @param month the month of the date.
   * @param year the year of the date.
   */
  public Date(MONTH month, Integer year) throws Exception{
    if (year.toString().length() != 4) {
      throw new IllegalArgumentException("Year must be a 4-digit Integer");
    } else {
      this.month = month;
      this.year = year;
    }
  }

  /**
   * Gets month.
   *
   * @return the month.
   */
  public MONTH getMonth() {
    return month;
  }

  /**
   * Gets year.
   *
   * @return the year.
   */
  public Integer getYear() {
    return year;
  }
}
