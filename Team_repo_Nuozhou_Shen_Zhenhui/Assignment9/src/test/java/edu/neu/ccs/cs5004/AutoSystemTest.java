package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutoSystemTest {

  private AutoSystem autoSystem;
  private String[] args;

  @Before
  public void setUp() throws Exception {
    this.autoSystem = new AutoSystem();
    this.args = new String[]{"--email", "--email-template", "emailtemplate.txt",
        "--output-dir", "emails", "--csv-file", "insurance_company_members.csv"};
  }

  @Test
  public void generateEmail() throws Exception {
    AutoSystem.main(this.args);
  }

  @Test
  public void generateLetter() throws Exception {
    this.args = new String[]{"--letter", "--letter-template", "lettertemplate.txt",
        "--output-dir", "letters", "--csv-file", "insurance_company_members.csv"};
    AutoSystem.main(this.args);
  }

  @Test
  public void generateSelfDefinedEmail() throws Exception {
    this.args = new String[]{"--email", "--email-template", "test_emailtemplate.txt",
        "--output-dir", "test_email", "--csv-file", "insurance_company_members.csv"};
    AutoSystem.main(this.args);
  }

  @Test
  public void generateSelfDefinedLetter() throws Exception {
    this.args = new String[]{"--letter", "--letter-template", "test_lettertemplate.txt",
        "--output-dir", "test_letter", "--csv-file", "insurance_company_members.csv"};
    AutoSystem.main(this.args);
  }


  @Test(expected = WrongTemplateTypeException.class)
  public void wrongTemplateTypeException() throws Exception {
    this.args = new String[]{"--email", "--letter-template", "emailtemplate.txt",
        "--output-dir", "emails", "--csv-file", "insurance_company_members.csv"};
    AutoSystem.main(this.args);
  }

  @Test(expected = UnrecognizedOptionException.class)
  public void unrecognizedOptionException() throws Exception {
    this.args = new String[]{"--email", "--letter-template", "emailtemplate.txt",
        "--output-dir", "emails", "--csv-file", "insurance_company_members.csv",
        "--help"};
    AutoSystem.main(this.args);
  }

  @Test(expected = MissingArgumentException.class)
  public void missingArgumentException() throws Exception {
    this.args = new String[]{"--email", "--letter-template", "--output-dir",
        "emails", "--csv-file", "insurance_company_members.csv", "--help"};
    AutoSystem.main(this.args);
  }

  @Test(expected = MissingOptionException.class)
  public void missingOptionException() throws Exception {
    this.args = new String[]{"--email-template", "emailtemplate.txt",
        "--output-dir", "emails", "--csv-file", "insurance_company_members.csv"};
    AutoSystem.main(this.args);
  }


  @Test
  public void toStringTest() throws Exception {
    assertEquals("AutoSystem", autoSystem.toString());
  }

  @Test
  public void hashCodeTest() throws Exception {
    assertEquals(1615452382, autoSystem.hashCode());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.autoSystem.equals(this.autoSystem));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.autoSystem.equals(null));
  }

  @Test
  public void notEqualsAnotherClass() throws Exception {
    assertFalse(this.autoSystem.equals(new CsvParser()));
  }

  @Test
  public void equals() throws Exception {
    assertTrue(this.autoSystem.equals(new AutoSystem()));
  }
}