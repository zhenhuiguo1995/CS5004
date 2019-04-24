package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParser {

  private static final String HEADER_SPLIT = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
  private static final String LINE_SPLIT = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
  private static final String LINE_REPLACE = "\"";

  /**
   * Parse csv.
   *
   * @param file the file
   */
  public static CustomerInfo parse(String file) {
    Map<String, Integer> map = new HashMap<>();
    List<String[]> contactInfo = new ArrayList<>();
    int colNum = 0;
    InputStream fileReader;
    Reader reader;
    BufferedReader infoFile = null;
    try {
      fileReader = new FileInputStream(file);
      reader = new InputStreamReader(fileReader, "UTF-8");
      infoFile = new BufferedReader(reader);
      String line;
      if ((line = infoFile.readLine()) != null) {
        String[] parts = line.replaceAll(LINE_REPLACE, " ").split(HEADER_SPLIT);
        colNum = parts.length;
        for (int i = 0; i < colNum; i++) {
          map.put(parts[i].trim(), i);
        }
      }
      while ((line = infoFile.readLine()) != null) {
        String[] parts = line.split(LINE_SPLIT);
        if (parts.length != colNum) {
          continue;
        }
        contactInfo.add(parts);
      }
    } catch (IOException ioe) {
      System.out.println("Error handling input file : " + ioe.getMessage());
    } finally {
      if (infoFile != null) {
        try {
          infoFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }
    return new CustomerInfo(contactInfo, map, colNum);
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

  @Override
  public String toString() {
    return "This is a CSV parser";
  }
}
