package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OptionsTest {


  private static final String[] TEST_ARGS_1 = new String[]{
      "--email", "--email-template", "email-template.txt",
      "--output-dir", "emails", "--csv-file", "customer.csv"};
  private Options testOptions = new Options();
  private CmdParser testCmdParser = new CmdParser();
  private CmdLineResult testCMDResult = new CmdLineResult();
  private Option testOption;

  @Before
  public void setUp() throws Exception {
    testOption = new Option("--email-template", "accept a filename that holds the template. "
        + "Required if --email is used", true);
    testOptions.addOptions(testOption);
    testCMDResult.setType("email");
    testOption.setArgs("email-template.txt");
  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("[ Options: {--email-template=Option{optName='--email-template', "
            + "description='accept a filename that holds the template. Required if --email is used', "
            + "requiredArg=true, args='email-template.txt'}} ][ Required Options:  ]",
        this.testOptions.toString());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.testOptions.equals(this.testOptions));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.testOptions.equals(null));
  }

  @Test
  public void classNotEquals() throws Exception {
    assertFalse(this.testOptions.equals(new CsvParser()));
  }

  @Test
  public void mapNotEquals() throws Exception {
    Options options = new Options();
    Option option = new Option("--letter-template",
        "accept a filename that holds the template. "
        + "Required if --letter is used", true);
    options.addOptions(option);
    assertFalse(this.testOptions.equals(options));
  }


  @Test
  public void hashCodeTest() throws Exception {
    assertEquals(this.testOptions.getOptionsMap().hashCode(), this.testOptions.hashCode());
  }

}