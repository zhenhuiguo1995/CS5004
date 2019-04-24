package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JournalTest {
  private String title;
  private Integer year;
  private String firstName;
  private String lastName;
  private Author author;
  private String journalName;
  private int issue;
  private MONTH month;
  private Journal journal;

  @Before
  public void setUp() throws Exception {
    this.title = "A discover beyond the Fourteen Seas";
    this.year = 2014;
    this.firstName = "Euron";
    this.lastName = "Greyjoy";
    this.author = new Author(this.firstName, this.lastName);
    this.journalName = "The Iron-Born Report";
    this.issue = 38;
    this.month = MONTH.Jan;
    this.journal = new Journal(this.title, this.author, this.year,
        this.journalName, this.issue, this.month);
  }

  @Test
  public void getJournalName() throws Exception {
    assertEquals(this.journalName, this.journal.getJournalName());
  }

  @Test
  public void getIssue() throws Exception {
    assertEquals(this.issue, this.journal.getIssue());
  }

  @Test
  public void getMonth() throws Exception {
    assertEquals(this.month, this.journal.getMonth());
  }

}