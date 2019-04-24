package edu.neu.ccs.cs5004;

import java.util.Map;

public class AutoSystem {
  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";
  private static final String EMAIL_TEMPLATE = "--email-template";
  private static final String LETTER_TEMPLATE = "--letter-template";


  protected static void main(String[] args) {

    Options options = new Options();
    options.addOptions(new Option("--email", "only generate email messages", false));
    options.addOptions(new Option("--email-template", "accept a filename that holds the template. "
        + "Required if --email is used", true));
    options.addOptions(new Option("--letter", "only generate letters", false));
    options.addOptions(new Option("--letter-template", "accept a filename that hold the "
        + "letter template. Required if --letter is used", true));
    options.addOptions(new Option("--output-dir", "accept the name of a folder, all\n"
        + "output is placed in this folder", true));
    options.addOptions(new Option("--csv-file", " accept the name of the csv file to\n"
        + "process", true));

    /*String[] test = new String[]{
        "--email", "--email-template", "email-template.txt",
        "--output-dir", "emails", "--csv-file", "customer.csv"};
    */
    String templateName = null;
    String outputDir = null;
    String csvFile = null;

    // determine the template and csvFile to read.
    CmdParser cmdParser = new CmdParser();
    CmdLineResult cmdLineResult = cmdParser.parse(args, options);
    for (Map.Entry<String, Option> entry : cmdLineResult.getOptions().entrySet()) {
      if (entry.getKey().equals(EMAIL_TEMPLATE) && entry.getValue().getArgs() != null) {
        templateName = entry.getValue().getArgs();
      }
      if (entry.getKey().equals(LETTER_TEMPLATE) && entry.getValue().getArgs() != null) {
        templateName = entry.getValue().getArgs();
      }
      if (entry.getKey().equals(OUTPUT_DIR)) {
        outputDir = entry.getValue().getArgs();
      }
      if (entry.getKey().equals(CSV_FILE)) {
        csvFile = entry.getValue().getArgs();
      }

    }


    String template = TemplateParser.parse(templateName);
    CustomerInfo customerInfo = CsvParser.parse(csvFile);
    // output dir should be provided by the user
    FileGenerator.generator(customerInfo, template, outputDir);
  }

  @Override
  public String toString() {
    return "AutoSystem";
  }

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (object == null || this.getClass() != object.getClass()) {
      return false;
    }
    return this.hashCode() == object.hashCode();
  }
}
