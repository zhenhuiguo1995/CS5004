package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class OptionTest {

  private String optName;
  private String description;
  private String args;
  private Boolean requiredArg;
  private Option testOption;

  @Before
  public void setUp() throws Exception {
    this.optName = "--email";
    this.description = "only generate email messages";
    this.requiredArg = false;
    this.testOption = new Option(this.optName, this.description, this.requiredArg);
  }

  @Test
  public void getOptName() throws Exception {
    assertEquals(this.optName, this.testOption.getOptName());
  }

  @Test
  public void getDescription() throws Exception {
    assertEquals(this.description, this.testOption.getDescription());
  }

  @Test
  public void isRequiredArg() throws Exception {
    assertFalse(this.testOption.isRequiredArg());
  }

  @Test
  public void getArgs() throws Exception {
    this.args = "--email emailtemplate.txt";
    this.testOption.setArgs(this.args);
    assertEquals(this.args, this.testOption.getArgs());
  }

  @Test
  public void setArgs() throws Exception {
    this.args = "--email emailtemplate.txt";
    this.testOption.setArgs(this.args);
    assertEquals(this.args, this.testOption.getArgs());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.testOption.equals(this.testOption));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.testOption.equals(null));
  }

  @Test
  public void notEqualsAnotherClass() throws Exception {
    assertFalse(this.testOption.equals(new ArrayList<Integer>()));
  }

  @Test
  public void equalsSameFild() throws Exception {
    this.args = "--email emailtemplate";
    this.testOption.setArgs(this.args);
    Option newOption = new Option(this.optName, this.description, this.requiredArg);
    newOption.setArgs(this.args);
    assertTrue(this.testOption.equals(newOption));
  }

  @Test
  public void notEqualsOptionName() throws Exception {
    this.args = "--email emailtemplate";
    this.testOption.setArgs(this.args);
    Option newOption = new Option("--letter ", this.description, this.requiredArg);
    newOption.setArgs(this.args);
    assertFalse(this.testOption.equals(newOption));
  }

  @Test
  public void notEqualsDescription() throws Exception {
    this.args = "--email emailtemplate";
    this.testOption.setArgs(this.args);
    Option newOption = new Option(this.optName, "generate email", this.requiredArg);
    newOption.setArgs(this.args);
    assertFalse(this.testOption.equals(newOption));
  }

  @Test
  public void notEqualsIsRequired() throws Exception {
    this.args = "--email emailtemplate";
    this.testOption.setArgs(this.args);
    Option newOption = new Option(this.optName, this.description, true);
    newOption.setArgs(this.args);
    assertFalse(this.testOption.equals(newOption));
  }

  @Test
  public void notEqualsArgs() throws Exception {
    this.args = "--email emailtemplate";
    this.testOption.setArgs(this.args);
    Option newOption = new Option(this.optName, this.description, true);
    newOption.setArgs("letter lettertemplate");
    assertFalse(this.testOption.equals(newOption));
  }

  // discuss
  @Test
  public void hashCodeTest() throws Exception {
    this.args = "--email emailtemplate";
    this.testOption.setArgs(this.args);
    assertEquals(1117073053, this.testOption.hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("Option{optName='--email', description='only generate email messages', "
            + "requiredArg=false, args='null'}",
        this.testOption.toString());
  }
}