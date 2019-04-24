package problem1;

/**
 * Represents information of the active years class, including start year and end year.
 */
public class ActiveYears {
  private static final String CURRENT = "current";
  private String startYear;
  private String endYear;

  public ActiveYears(String startYear, String endYear) throws Exception{
    if (endYear.equals(CURRENT)){
      if (startYear.length() == 4) {
        this.startYear = startYear;
        this.endYear = endYear;
      } else {
        throw new IllegalArgumentException("Start year must be a 4-digit number!");
      }
    } else {
      if (startYear.length() == 4 && endYear.length() == 4) {
        this.startYear = startYear;
        this.endYear = endYear;
      } else {
        throw new IllegalArgumentException("Start year and end year must be 4-digit numbers!");
      }
    }
  }

  /**
   * @return the start year of the actor.
   */
  public String getStartYear() {
    return startYear;
  }

  /**
   * @return the end year of the actor.
   */
  public String getEndYear() {
    return endYear;
  }

  public String getString() {
    return startYear + "-" + endYear;
  }
}
