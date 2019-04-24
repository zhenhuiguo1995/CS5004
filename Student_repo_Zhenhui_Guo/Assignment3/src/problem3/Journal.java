package problem3;

/**
 * Represents details of a journal.
 */
public class Journal extends AbstractPublication {
  private String journalName;
  private int issue;
  private MONTH month;

  /**
   * Creates a publication.
   *
   * @param title the title of the publication.
   * @param author the author of the publication.
   * @param year the year of the publication.
   * @param journalName the journal name
   * @param issue the issue
   * @param month the month
   * @throws Exception the exception
   */
  public Journal(String title, Author author, Integer year, String journalName, int issue, MONTH month)
      throws Exception {
    super(title, author, year);
    this.journalName = journalName;
    this.issue = issue;
    this.month = month;
  }

  /**
   * Gets journal name.
   *
   * @return the name of the journal.
   */
  public String getJournalName() {
    return journalName;
  }

  /**
   * Gets issue.
   *
   * @return the issue number.
   */
  public int getIssue() {
    return issue;
  }

  /**
   * Gets month.
   *
   * @return the month.
   */
  public MONTH getMonth() {
    return month;
  }
}
