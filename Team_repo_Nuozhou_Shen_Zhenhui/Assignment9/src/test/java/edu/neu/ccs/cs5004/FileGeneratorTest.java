package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileGeneratorTest {

  private CustomerInfo customerInfo;
  private String template;
  private String outputDir;
  private FileGenerator fileGenerator;


  @Before
  public void setUp() throws Exception {
    this.customerInfo = CsvParser.parse("insurance_company_members.csv");
    this.template = TemplateParser.parse("lettertemplate.txt");
    this.outputDir = "Production\\Test";
    this.fileGenerator = new FileGenerator();
  }

  @Test
  public void generator() throws Exception {
    FileGenerator.generator(this.customerInfo, this.template, this.outputDir);
  }

  @Test
  public void generatorAnotherFile() throws Exception {
    this.outputDir = "Output";
    FileGenerator.generator(this.customerInfo, this.template, this.outputDir);
  }


  @Test
  public void toStringTest() throws Exception {
    assertEquals("This is a File Generator", this.fileGenerator.toString());
  }

  @Test
  public void hashCodeTest() throws Exception {
    assertEquals(-1256816990, this.fileGenerator.hashCode());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.fileGenerator.equals(this.fileGenerator));
  }

  @Test
  public void notEquals() throws Exception {
    assertFalse(this.fileGenerator.equals(new CsvParser()));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.fileGenerator.equals(null));
  }

  @Test
  public void equals() throws Exception {
    assertTrue(this.fileGenerator.equals(new FileGenerator()));
  }

}