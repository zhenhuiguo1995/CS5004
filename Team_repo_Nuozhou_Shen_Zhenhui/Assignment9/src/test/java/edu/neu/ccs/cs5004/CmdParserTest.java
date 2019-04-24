package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CmdParserTest {

  private static final String[] TEST_ARGS_1 = new String[]{
      "--email", "--email-template", "email-template.txt",
      "--output-dir", "emails", "--csv-file", "customer.csv"};
  private static final String[] TEST_ARGS_2 = new String[]{
      "--email", "--email-template", "--output-dir", "emails",
      "--csv-file", "customer.csv"};
  private static final String[] TEST_ARGS_3 = new String[]{
      "--email", "--email-template", "email-template.txt",
      "--output-dir", "emails"};
  private static final String[] TEST_ARGS_4 = new String[]{
      "--email", "--letter-template", "email-template.txt",
      "--output-dir", "emails", "--csv-file", "customer.csv"};
  private static final String[] TEST_ARGS_5 = new String[]{
      "--email", "--unrecognized", "email-template.txt",
      "--output-dir", "emails", "--csv-file", "customer.csv"};
  private Options testOptions = new Options();
  private CmdParser testCmdParser = new CmdParser();
  private CmdParser testCmdParser2 = new CmdParser();
  private CmdLineResult testCMDResult = new CmdLineResult();
  private Option testOption1;
  private Option testOption2;
  private Option testOption3;
  private Option testOption4;
  private Option testOption5;
  private Option testOption6;

  @Before
  public void setUp() throws Exception {
    testOption1 = new Option("--email", "only generate email messages", false);
    testOption2 = new Option("--email-template", "accept a filename that holds the template. "
        + "Required if --email is used", true);
    testOption3 = new Option("--letter", "only generate letters", false);
    testOption4 = new Option("--letter-template", "accept a filename that hold the "
        + "letter template. Required if --letter is used", true);
    testOption5 = new Option("--output-dir", "accept the name of a folder, all\n"
        + "output is placed in this folder", true);
    testOption6 = new Option("--csv-file", " accept the name of the csv file to\n"
        + "process", true);
    testOptions.addOptions(testOption1);
    testOptions.addOptions(testOption2);
    testOptions.addOptions(testOption3);
    testOptions.addOptions(testOption4);
    testOptions.addOptions(testOption5);
    testOptions.addOptions(testOption6);
    testCMDResult.setType("email");
    testOption2.setArgs("email-template.txt");
    testOption5.setArgs("emails");
    testOption6.setArgs("customer.csv");
    testCMDResult.addOption(testOption1);
    testCMDResult.addOption(testOption2);
    testCMDResult.addOption(testOption5);
    testCMDResult.addOption(testOption6);
  }

  @Test
  public void testParse() {
    CmdLineResult actualResult = testCmdParser.parse(TEST_ARGS_1, testOptions);
    assertEquals(testCMDResult, actualResult);
  }

  @Test(expected = MissingArgumentException.class)
  public void testMissedArgumentException() {
    testCmdParser.parse(TEST_ARGS_2, testOptions);
  }

  @Test(expected = MissingOptionException.class)
  public void testMissedOptionException() {
    testCmdParser.parse(TEST_ARGS_3, testOptions);
  }

  @Test(expected = WrongTemplateTypeException.class)
  public void testWrongTemplateTypeException() {
    testCmdParser.parse(TEST_ARGS_4, testOptions);
  }

  @Test(expected = UnrecognizedOptionException.class)
  public void testUnrecognizedException() {
    testCmdParser.parse(TEST_ARGS_5, testOptions);
  }

  @Test(expected = UnrecognizedOptionException.class)
  public void testNullArgs() throws Exception {
    testCmdParser.parse(new String[]{""}, testOptions);
  }

  @Test
  public void testEquals() {
    assertTrue(testCmdParser.equals(testCmdParser2));
    assertTrue(testCmdParser.equals(testCmdParser));
    assertFalse(testCmdParser.equals(null));
    assertFalse(testCmdParser.equals(testCMDResult));
  }

  @Test
  public void testHashCode() {
    assertEquals(testCmdParser.hashCode(), testCmdParser.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(testCmdParser.toString(), testCmdParser.toString());
  }


}