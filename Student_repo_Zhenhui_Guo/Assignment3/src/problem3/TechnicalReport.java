package problem3;

import org.omg.PortableInterceptor.INACTIVE;

public class TechnicalReport extends AbstractPublication{
  private int trId;
  private String institution;
  /**
   * Creates a publication.
   *
   * @param title the title of the publication.
   * @param author the author of the publication.
   * @param year the year of the publication.
   */
  public TechnicalReport(String title, Author author, Integer year, int trId, String institution)
      throws Exception {
    super(title, author, year);
    this.trId = trId;
    this.institution = institution;
  }

  /**
   * Convert a technical review to a journal.
   *
   * @param journalName the name of the journal.
   * @param issue the issue number of the journal.
   * @param month the issue month of the journal.
   * @param year the issue year of the journal.
   *
   * @return a journal object.
   */
  public Journal turnToJournal(String journalName, int issue, MONTH month, Integer year)
      throws Exception {
    return new Journal(this.getTitle(), this.getAuthor(), year,
        journalName, issue, month);
  }

  /**
   * @return the TR-ID of the publication.
   */
  public int getTrId() {
    return trId;
  }

  /**
   * @return the institution name of the publication.
   */
  public String getInstitution() {
    return institution;
  }
}
