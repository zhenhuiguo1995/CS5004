package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DriverLicenseTest {

  private Name name;
  private Name name2;
  private LocalDate testDate;
  private LocalDate testDate2;
  private Country country;
  private LocalDate issuanceDate;
  private LocalDate expirationDate;
  private DriverLicense license;
  private DriverLicense license2;
  private DriverLicense license3;
  private DriverLicense license4;
  private DriverLicense license5;
  private DriverLicense license6;
  private DriverLicense license7;
  private DriverLicense license8;
  private DriverLicense license9;
  private DriverLicense license10;

  @Before
  public void setUp() throws Exception {
    name = new Name("Alice", "Green");
    name2 = new Name("Bob", "Green");
    testDate = LocalDate.of(2018, 2, 3);
    testDate2 = LocalDate.of(2019, 1, 1);
    country = Country.US;
    issuanceDate = LocalDate.of(2009, 10, 3);
    expirationDate = LocalDate.of(2022, 12, 3);
    license = new DriverLicense("109920", name, "220 Seattle Ave", testDate, country, "WA",
        issuanceDate, expirationDate);
    license2 = new DriverLicense("109920", name2, "220 Seattle Ave", testDate, country, "WA",
        issuanceDate, expirationDate);
    license3 = new DriverLicense("102220", name, "110 Seattle Ave", testDate, country, "WA",
        issuanceDate, expirationDate);
    license4 = new DriverLicense("102220", name, "220 Seattle Ave", testDate2, country, "WA",
        issuanceDate, expirationDate);
    license5 = new DriverLicense("102220", name, "220 Seattle Ave", testDate, Country.AU, "WA",
        issuanceDate, expirationDate);
    license6 = new DriverLicense("102220", name, "220 Seattle Ave", testDate, country, "PA",
        issuanceDate, expirationDate);
    license7 = new DriverLicense("102220", name, "220 Seattle Ave", testDate, country, "WA",
        issuanceDate, expirationDate);
    license8 = new DriverLicense("102220", name, "220 Seattle Ave", testDate, country, "WA",
        testDate, expirationDate);
    license9 = new DriverLicense("102220", name, "220 Seattle Ave", testDate, country, "WA",
        issuanceDate, testDate);
    license10 = new DriverLicense("109920", name, "220 Seattle Ave", testDate, country, "WA",
        issuanceDate, expirationDate);

  }

  @Test
  public void getName() {
    assertEquals(name, license.getName());
  }

  @Test
  public void getBirthday() {
    assertEquals(testDate, license.getBirthday());
  }

  @Test
  public void getCountry() {
    assertEquals(Country.US, license.getCountry());
  }

  @Test
  public void getIssuanceDate() {
    assertEquals(issuanceDate, license.getIssuanceDate());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(expirationDate, license.getExpirationDate());
  }

  @Test
  public void testToString() {
    assertEquals(
        "DriverLicense{number='109920', name=Name{firstName='Alice', lastName='Green'}, address='220 Seattle Ave', birthday=2018-02-03, country='US', state='WA', issuanceDate=2009-10-03, expirationDate=2022-12-03}",
        license.toString());
  }

  @Test
  public void equals() {
    assertTrue(license.equals(license));
    assertFalse(license.equals(null));
    assertFalse(license.equals("TEST"));
    assertFalse(license.equals(license2));
    assertFalse(license.equals(license3));
    assertFalse(license.equals(license4));
    assertFalse(license.equals(license5));
    assertFalse(license.equals(license6));
    assertFalse(license.equals(license7));
    assertFalse(license.equals(license8));
    assertFalse(license.equals(license9));
    assertTrue(license.equals(license));
  }

  @Test
  public void testHashCode() {
    assertEquals(license.hashCode(), license.hashCode());
    assertNotEquals(license.hashCode(), license2.hashCode());
  }
}