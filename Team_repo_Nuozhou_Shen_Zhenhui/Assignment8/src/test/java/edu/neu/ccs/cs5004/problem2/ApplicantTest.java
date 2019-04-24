package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ApplicantTest {

  private Driver driver;
  private Driver driver2;
  private List<MovingViolation> movingList;
  private List<NonMovingViolation> nonMovingList;
  private Name testName;
  private Name testName2;
  private LocalDate testDate;
  private LocalDate testDate2;
  private MovingViolation testViolation;
  private NonMovingViolation testViolation2;
  private DriverHistory history;
  private LocalDate issuanceDate;
  private LocalDate expirationDate;
  private DriverLicense license;
  private DriverLicense license2;

  private List<Crash> crashList;
  private Crash testCrash;
  private VehicleHistory history2;
  private Vehicle vehicle;

  private List<Person> coverList;
  private Person person1;
  private Insurance insurance;
  private Applicant applicant;
  private Applicant applicant2;
  private Applicant applicant3;

  @Before
  public void setUp() throws Exception {
    testName = new Name("Alice", "Green");
    testName2 = new Name("Emma", "Green");
    testDate = LocalDate.of(1980, 2, 3);
    testDate2 = LocalDate.of(2000, 12, 3);
    testViolation = new MovingViolation(testName, testDate, MovingViolationReason.DistractedDriving);
    testViolation2 = new NonMovingViolation(testName, testDate, NonMovingViolationReason.ParkingViolation);
    movingList = new ArrayList<>();
    nonMovingList = new ArrayList<>();
    movingList.add(testViolation);
    nonMovingList.add(testViolation2);
    history = new DriverHistory(movingList, nonMovingList);
    driver = new Driver(testName, testDate, history);
    driver2 = new Driver(testName2, testDate2, history);
    issuanceDate = LocalDate.of(2009, 10, 3);
    expirationDate = LocalDate.of(2022, 12, 3);
    license = new DriverLicense("109920", testName, "220 Seattle Ave", testDate, Country.US, "WA",
        issuanceDate, expirationDate);
    license2 = new DriverLicense("202020", testName2, "220 Seattle Ave", testDate, Country.US, "WA",
        issuanceDate, expirationDate);
    person1 = new Person(testName, testDate);
    coverList = new ArrayList<>();
    coverList.add(person1);
    insurance = new Insurance(driver, coverList, expirationDate);
    testDate2 = LocalDate.of(2010, 7, 23);
    testCrash = new Crash(testDate2, CrashReason.FenderBender);
    crashList = new ArrayList<>();
    crashList.add(testCrash);
    history2 = new VehicleHistory(movingList, nonMovingList, crashList);
    vehicle = new Vehicle("Honda", "CRV", 2010, person1, history2);
    applicant = new Applicant(driver, license, vehicle, insurance);
    applicant2 = new Applicant(driver2, license, vehicle, insurance);
    applicant3 = new Applicant(driver2, license2, vehicle, insurance);

  }

  @Test
  public void getDriver() {
    assertEquals(driver, applicant.getDriver());
  }

  @Test
  public void getDriverLicense() {
    assertEquals(license, applicant.getDriverLicense());
  }

  @Test
  public void getVehicle() {
    assertEquals(vehicle, applicant.getVehicle());
  }

  @Test
  public void getInsurance() {
    assertEquals(insurance, applicant.getInsurance());
  }

  @Test
  public void testToString() {
    assertEquals(
        "Applicant{driver=Driver{history=DriverHistory{movingAbstractViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=DistractedDriving}], nonMovingAbstractViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=ParkingViolation}]}}, driverLicense=DriverLicense{number='109920', name=Name{firstName='Alice', lastName='Green'}, address='220 Seattle Ave', birthday=1980-02-03, country='US', state='WA', issuanceDate=2009-10-03, expirationDate=2022-12-03}, vehicle=Vehicle{make='Honda', model='CRV', year=2010, owner=Person{name=Name{firstName='Alice', lastName='Green'}, birthday=1980-02-03}, vehicleHistory=VehicleHistory{movingViolationList=[MovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=DistractedDriving}], nonMovingViolationList=[NonMovingViolation{driverName=Name{firstName='Alice', lastName='Green'}, date=1980-02-03, violation=ParkingViolation}], crashList=[Crash{date=2010-07-23, crashReason=FenderBender}]}}}"
        ,applicant.toString());
  }

  @Test
  public void equals() {
    assertTrue(applicant.equals(applicant));
    assertFalse(applicant.equals(null));
    assertFalse(applicant.equals("TEST"));
    assertFalse(applicant.equals(applicant2));
    assertFalse(applicant.equals(applicant3));

  }

  @Test
  public void testHashCode() {
    assertEquals(applicant.hashCode(), applicant.hashCode());
    assertNotEquals(applicant.hashCode(), applicant2.hashCode());
  }
}