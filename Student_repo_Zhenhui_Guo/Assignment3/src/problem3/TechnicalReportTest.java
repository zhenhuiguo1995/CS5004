package problem3;

import static org.junit.Assert.*;

import javax.print.DocFlavor.STRING;
import org.junit.Before;
import org.junit.Test;

public class TechnicalReportTest {
  private String title;
  private String firstName;
  private String lastName;
  private Author author;
  private int trId;
  private String institution;
  private Integer year;
  private TechnicalReport technicalReport;

  @Before
  public void setUp() throws Exception {
    this.title = "Wild Fire: Is it possible to burn the great Septen?";
    this.firstName = "Cersi";
    this.lastName = "Lannister";
    this.author = new Author(this.firstName, this.lastName);
    this.trId = 2897;
    this.year = 2017;
    this.institution = "The Queen's Guard of King's Landing";
    this.technicalReport = new TechnicalReport(this.title, this.author,
        this.year, this.trId, this.institution);
  }

  @Test
  public void turnToJournal() throws Exception {
    String journalName = "Westores: a History";
    int issue = 1000;
    MONTH month = MONTH.Feb;
    Integer year = 2016;
    Journal journal = this.technicalReport.turnToJournal(journalName, issue, month, year);
    assertEquals(journalName, journal.getJournalName());
    assertEquals(issue, journal.getIssue());
    assertEquals(month, journal.getMonth());
    assertEquals(year, journal.getYear());
    assertEquals(this.title, journal.getTitle());
    assertEquals(this.author, journal.getAuthor());
  }

  @Test
  public void getTrId() throws Exception {
    assertEquals(this.trId, this.technicalReport.getTrId());
  }

  @Test
  public void getInstitution() throws Exception {
    assertEquals(this.institution, this.technicalReport.getInstitution());
  }

}