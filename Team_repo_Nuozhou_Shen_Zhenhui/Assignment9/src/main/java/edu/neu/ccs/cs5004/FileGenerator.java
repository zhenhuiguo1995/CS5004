package edu.neu.ccs.cs5004;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class File generator.
 */
public class FileGenerator {

  private static final String PATH_PATTERN = "[/\\\\]+";
  private static final String REPLACE_PATTERN = "\\[\\[(.*?)\\]\\]";
  private static final int GROUP_NUM = 1;
  private static final String FILE_NAME = "file";
  private static final String REPLACE_PATTERN2 = "^\"|\"$";

  /**
   * generator.
   *
   * @param customerInfo the customer info
   * @param template the template
   * @param outputDir the output dir
   */
  public static void generator(CustomerInfo customerInfo, String template, String outputDir) {
    BufferedWriter outputFile = null;
    String fileName = null;
    String errString = "Failed to close output stream in finally block";
    for (int i = 0; i < customerInfo.getContactInfo().size(); i++) {
      String path = (outputDir + "\\").replaceAll(PATH_PATTERN, Matcher.quoteReplacement(System
          .getProperty("file.separator")));
      File outFile = new File(path + FILE_NAME + i + ".txt");
      try {
        boolean folderExisted =
            outFile.getParentFile().exists() || outFile.getParentFile().mkdirs();
        if (!folderExisted) {
          throw new IOException("Unable to create the path");
        }
        outputFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),
            StandardCharsets.UTF_8));
        String[] lines = template.split(System.getProperty("line.separator"));
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
          Pattern pattern = Pattern.compile(REPLACE_PATTERN);
          Matcher matcher = pattern.matcher(template);
          while (matcher.find()) {
            String wordToReplace = matcher.group(GROUP_NUM);
            int col = customerInfo.getMap().get(wordToReplace);
            line = line
                .replace("[[" + wordToReplace + "]]",
                    customerInfo.getContactInfo().get(i)[col].replaceAll(REPLACE_PATTERN2, ""));
          }
          stringBuilder.append(line);
          stringBuilder.append(System.lineSeparator());
        }
        outputFile.write(stringBuilder.toString());
      } catch (IOException ioe) {
        System.out.println("Error handling the input file: " + ioe.getMessage());
        ioe.printStackTrace();
      } finally {
        if (outputFile != null) {
          try {
            outputFile.close();
          } catch (IOException e) {
            System.out.println(errString);
            e.printStackTrace();
          }
        }
      }
    }
  }

  @Override
  public String toString() {
    return "This is a File Generator";
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
