package problem3;

/**
 * Represents details of a conference.
 */
public class Conference extends AbstractPublication {
  private String conferenceName;
  private MONTH month;
  private Location location;

  /**
   * Creates a publication.
   *
   * @param title the title of the publication.
   * @param author the author of the publication.
   * @param year the year of the publication.
   * @param conferenceName the conference name
   * @param month the month
   * @param location the location
   * @throws Exception the exception
   */
  public Conference(String title, Author author, Integer year, String conferenceName, MONTH month,
      Location location) throws Exception {
    super(title, author, year);
    this.conferenceName = conferenceName;
    this.month = month;
    this.location = location;
  }

  /**
   * Gets conference name.
   *
   * @return the conference name
   */
  public String getConferenceName() {
    return conferenceName;
  }

  /**
   * Gets month.
   *
   * @return the month
   */
  public MONTH getMonth() {
    return month;
  }

  /**
   * Gets location.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }
}
