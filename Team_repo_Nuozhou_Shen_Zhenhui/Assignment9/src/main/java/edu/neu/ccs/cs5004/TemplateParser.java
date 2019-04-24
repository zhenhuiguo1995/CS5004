package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 * The class Template parser.
 */
public class TemplateParser {

  /**
   * Read the template file and records its content as a string.
   *
   * @param templateFile the template file
   * @return the template
   */
  public static String parse(String templateFile) {
    InputStream file;
    Reader reader;
    BufferedReader inputFile = null;
    StringBuilder stringBuilder = new StringBuilder();
    String errString = "Failed to close input stream in finally block";
    try {
      file = new FileInputStream(templateFile);
      reader = new InputStreamReader(file,"UTF-8");
      inputFile = new BufferedReader(reader);
      String line;
      while ((line = inputFile.readLine()) != null) {
        stringBuilder.append(line);
        stringBuilder.append(System.lineSeparator());
      }
      inputFile.close();
    } catch (IOException e) { // FileNotFoundException is an IOException
      System.out.println("Exception in handling the file : " + e.getMessage());
      return "";
    } finally {
      // if an exception is thrown, the file should be closed.
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println(errString);
        }
      }
    }
    return stringBuilder.toString();
  }

  @Override
  public String toString() {
    return "This is a Template Parser";
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

