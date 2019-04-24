package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CmdLineResultTest {

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
  private static final String testType1 = "Letter";
  private static final String testType2 = "Email";
  private Options testOptions = new Options();
  private CmdParser testCmdParser = new CmdParser();
  private CmdLineResult testCMDResult = new CmdLineResult();
  private CmdLineResult testCMDResult2 = new CmdLineResult();
  private Option Option;
  private Option testOption1;
  private Option testOption2;
  private Option testOption5;
  private Option testOption6;

  @Before
  public void setUp() {
    testOption1 = new Option("--email", "only generate email messages", false);
    testOption2 = new Option("--email-template", "accept a filename that holds the template. "
        + "Required if --email is used", true);
    testOption5 = new Option("--output-dir", "accept the name of a folder, all\n"
        + "output is placed in this folder", true);
    testOption6 = new Option("--csv-file", " accept the name of the csv file to\n"
        + "process", true);

    Option = new Option("--email-template", "accept a filename that holds the template. "
        + "Required if --email is used", true);
    testOptions.addOptions(Option);
    testCMDResult.setType("email");
    testCMDResult2.addOption(Option);
    testCMDResult2.setType("email");
    Option.setArgs("email-template.txt");
    testCMDResult.addOption(Option);
  }

  @Test
  public void checkValidity_isValid() {
    testCMDResult.addOption(testOption1);
    testCMDResult.addOption(testOption2);
    testCMDResult.addOption(testOption5);
    testCMDResult.addOption(testOption6);
    testOption2.setArgs("XX.txt");
    testOption5.setArgs("XX.csv");
    testOption6.setArgs("DIR");
    try {
      testCMDResult.checkValidity();
    } catch (RuntimeException e) {
      fail("No exception should be thrown/");
    }
  }

  @Test
  public void checkValidity_missOptions() {
    testCMDResult.addOption(testOption1);
    testCMDResult.addOption(testOption2);
    testCMDResult.addOption(testOption6);
    testOption2.setArgs("XX.txt");
    testOption2.setArgs("XX.csv");
    testOption6.setArgs("DIR");
    try {
      testCMDResult.checkValidity();
      fail("An Missing Option Exception should be thrown.");
    } catch (MissingOptionException e) {
    }
  }

  @Test
  public void checkValidity_missArguments() {
    testCMDResult.addOption(testOption1);
    testCMDResult.addOption(testOption2);
    testCMDResult.addOption(testOption5);
    testCMDResult.addOption(testOption6);
    testOption2.setArgs("XX.txt");
    testOption5.setArgs("XX.csv");
    try {
      testCMDResult.checkValidity();
      fail("An Missing Argument Exception should be thrown.");
    } catch (MissingArgumentException e) {
    }
  }

  @Test
  public void checkValidity_inconsistentType() {
    testCMDResult.addOption(testOption1);
    testCMDResult.addOption(testOption2);
    testCMDResult.addOption(testOption5);
    testCMDResult.addOption(testOption6);
    testOption2.setArgs("XX.txt");
    testOption5.setArgs("XX.csv");
    testOption6.setArgs("DIR");
    testCMDResult.setType("letter");
    try {
      testCMDResult.checkValidity();
      fail("A WrongTemplateException should be thrown.");
    } catch (WrongTemplateTypeException e) {
    }
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.testCMDResult.equals(testCMDResult));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.testCMDResult.equals(null));
  }

  @Test
  public void notEqualsAnotherClass() throws Exception {
    assertFalse(this.testCMDResult.equals(testCmdParser));
  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("CmdLineResult{type='email', "
        + "options={--email-template=Option{optName='--email-template', "
        + "description='accept a filename that holds the template. Required if --email is used', "
        + "requiredArg=true, args='email-template.txt'}}}", this.testCMDResult.toString());
  }

  @Test
  public void hashCodeTest() throws Exception {
    assertEquals(-1563431489, this.testCMDResult.hashCode());
  }

}