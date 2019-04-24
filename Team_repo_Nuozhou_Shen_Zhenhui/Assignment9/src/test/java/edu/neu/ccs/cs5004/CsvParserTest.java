package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CsvParserTest {

  private String fileName;
  private CsvParser csvParser;

  @Before
  public void setUp() throws Exception {
    this.csvParser = new CsvParser();
    this.fileName = "insurance_company_members.csv";

  }

  @Test
  public void parseSuccess() throws Exception {
    CsvParser.parse(this.fileName);
  }

  @Test
  public void parseFail() throws Exception {
    this.fileName = "file_does_not_exist.csv";
    try {
      CsvParser.parse(this.fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("This is a CSV parser", this.csvParser.toString());
  }

  @Test
  public void hashCodeTest() throws Exception {
    assertEquals(-1910928756, this.csvParser.hashCode());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.csvParser.equals(this.csvParser));
  }

  @Test
  public void classNotEquals() throws Exception {
    assertFalse(this.csvParser.equals(new CmdParser()));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.csvParser.equals(null));
  }

  @Test
  public void equals() throws Exception {
    assertTrue(this.csvParser.equals(new CsvParser()));
  }

}