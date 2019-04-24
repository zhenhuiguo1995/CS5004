package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class TemplateParserTest {

  private String templateFile;
  private TemplateParser templateParser;

  @Before
  public void setUp() throws Exception {
    this.templateFile = "lettertemplate.txt";
    this.templateParser = new TemplateParser();
  }

  @Test
  public void parse() throws Exception {
    String template = TemplateParser.parse(this.templateFile);
    assertEquals("[[company_name]].\n"
        + "[[first_name]] [[last_name]]\n"
        + "[[address]], [[city]],\n"
        + "[[county]], [[state]], [[zip]]\n"
        + "([[email]])\n"
        + "\n"
        + "Dear [[first_name]] [[last_name]], \n"
        + "\n"
        + "Similarly, we also have a template for the company's letter: \n"
        + "[[first_name]] [[last_name]]\n"
        + "[[address]], [[city]],\n"
        + "[[county]], [[state]], [[zip]]\n"
        + "([[email]])\n"
        + "\n"
        + "Dear [[first_name]] [[last_name]],\n"
        + "As you may have heard or read, last month we learned that criminals forced their way into our systems, \n"
        + "and stole information about our customers. Late last week, as part of our ongoing investigation, \n"
        + "we learned that the taken information includes names, mailing addresses, phone numbers or email addresses. \n"
        + "\n"
        + "I am writing to make you aware that your name, mailing address, phone number or email address may \n"
        + "have been taken during the intrusion. \n"
        + "\n"
        + "I am truly sorry this incident occurred, and I sincerely regret any inconvenience it may cause you. \n"
        + "\n"
        + "Because we value you as a customer, and because your trust is important to us, our company is \n"
        + "offering you one year of free credit monitoring through Experianâ€™s ProtectMyID product, which includes \n"
        + "identity theft insurance where available. Enclosed please find your additional information about your \n"
        + "free credit card monitoring.\n"
        + "\n"
        + "\n"
        + "You can find additional information and FAQs about this incident at our website. If you have further questions, \n"
        + "you may call us at 866-852-8680.\n"
        + " \n"
        + "Thank you for your patience and your loyalty. \n"
        + "\n"
        + "Sincerely, \n"
        + "Insurance Company CEO\n", template);
  }

  @Test
  public void IOException() throws IOException {
    assertEquals("", TemplateParser.parse("filedoesnotexists.txt"));
  }

  @Test
  public void toStringTest() throws Exception {
    assertEquals("This is a Template Parser", new TemplateParser().toString());
  }

  @Test
  public void hashCodeTest() throws Exception {
    assertEquals(600179570, this.templateParser.hashCode());
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(this.templateParser.equals(this.templateParser));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(this.templateParser.equals(null));
  }

  @Test
  public void classNotEquals() throws Exception {
    assertFalse(this.templateParser.equals(new CsvParser()));
  }

  @Test
  public void equals() throws Exception {
    assertTrue(this.templateParser.equals(new TemplateParser()));
  }

}