package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class RegistrationValidatorTest {
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
  private Person person2;
  private Insurance insurance;
  private Applicant applicant;
  private Applicant applicant2;
  private Applicant applicant3;
  private RegistrationValidator registrationValidator;
  private AcceptedPool pool;


  @Before
  public void setUp() throws Exception {
    testName = new Name("Alexa", "Watson");
    testName2 = new Name("Emily", "Wander");
    testDate = LocalDate.of(1995, 5, 14);
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
    license2 = new DriverLicense("202020", testName2, "535 Pontius Ave", testDate, Country.US, "WA",
        issuanceDate, expirationDate);
    person1 = new Person(testName, testDate);
    person2 = new Person(testName2, testDate2);
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
    pool = new AcceptedPool(new HashMap<>());
    registrationValidator = new RegistrationValidator(pool);
  }

  @Test
  public void validateApplicant() throws Exception {
    assertTrue(registrationValidator.validateApplicant(applicant));
  }

  @Test
  public void validateApplicantFalse() throws Exception {
    assertFalse(registrationValidator.validateApplicant(applicant2));
  }

  @Test
  public void validateApplicantFalseAgain() throws Exception {
    assertFalse(registrationValidator.validateApplicant(applicant3));
  }

  @Test
  public void checkAgeTrue() throws Exception {
    assertTrue(registrationValidator.checkAge(driver));
  }

  @Test
  public void checkAgeFalse() throws Exception {
    assertFalse(registrationValidator.checkAge(driver2));
  }

  @Test
  public void checkLicenseInformationTrue() throws Exception {
    assertTrue(registrationValidator.checkLicenseInformation(driver, license));
  }

  @Test
  public void checkLicenseInformationFalse() throws Exception {
    license = new DriverLicense("109920",testName2, "535 Pontius Ave", testDate2,
        Country.AU, "NSW", LocalDate.of(2009, 3, 9),
        LocalDate.of(2019, 3, 9));
    assertFalse(registrationValidator.checkLicenseInformation(driver, license));
  }

  @Test
  public void checkLicenseInformationDurationNotEnough() throws Exception {
    license = new DriverLicense("109920",testName2, "535 Pontius Ave", testDate2,
        Country.AU, "NSW", LocalDate.of(2019, 3, 9),
        LocalDate.of(2029, 3, 9));
    assertFalse(registrationValidator.checkLicenseInformation(driver, license));
  }

  @Test
  public void checkVehicleInformationTrue() throws Exception {
    assertTrue(registrationValidator.checkVehicleInformation(vehicle));
  }

  @Test
  public void checkVehicleInformationFalse() throws Exception {
    vehicle = new Vehicle("Honda", "CRV", 1988, person1, history2);
    assertFalse(registrationValidator.checkVehicleInformation(vehicle));
  }

  @Test
  public void checkInsuranceInformationTrue() throws Exception {
    assertTrue(registrationValidator.checkInsuranceInformation(driver, vehicle, insurance));
  }

  @Test
  public void checkInsuranceInformationNotOfficialOwner() throws Exception {
    driver = new Driver(testName, testDate2, history);
    assertFalse(registrationValidator.checkInsuranceInformation(driver, vehicle, insurance));
  }

  @Test
  public void checkInsuranceInformationInsuranceExpired() throws Exception {
    insurance = new Insurance(driver, coverList, LocalDate.of(2019, 3, 9));
    assertFalse(registrationValidator.checkInsuranceInformation(driver, vehicle, insurance));
  }

  @Test
  public void checkInsuranceInformationNotInsuredDriver() throws Exception {
    coverList = new ArrayList<>();
    insurance = new Insurance(driver, coverList, expirationDate);
    vehicle = new Vehicle("Honda", "CRV", 2010, person2, history2);
    assertFalse(registrationValidator.checkInsuranceInformation(driver, vehicle, insurance));
  }

  @Test
  public void checkInsuranceInformationIsInsuredDriver() throws Exception {
    coverList = new ArrayList<>();
    coverList.add(person2);
    insurance = new Insurance(person1, coverList, expirationDate);
    vehicle = new Vehicle("Honda", "CRV", 2010, person2, history2);
    assertFalse(registrationValidator.checkInsuranceInformation(driver, vehicle, insurance));
  }

  @Test
  public void checkDriverHistoryNoMovingViolation() throws Exception {
    movingList = new ArrayList<>();
    history = new DriverHistory(movingList, nonMovingList);
    assertTrue(registrationValidator.checkDriverHistory(history));
  }

  @Test
  public void checkDriverHistoryViolationContainsMovingViolation() throws Exception {
    movingList = new ArrayList<>();
    movingList.add(new MovingViolation(testName, testDate,
        MovingViolationReason.RecklessDriving));
    history = new DriverHistory(movingList, nonMovingList);
    assertTrue(registrationValidator.checkDriverHistory(history));
  }


  @Test
  public void checkDriverHistoryViolationContainsAllMovingViolation() throws Exception {
    movingList = new ArrayList<>();
    movingList.add(new MovingViolation(testName, testDate,
        MovingViolationReason.RecklessDriving));
    movingList.add(new MovingViolation(testName, testDate,
        MovingViolationReason.DrivingWithoutValidLicenseOrInsurance));
    movingList.add(new MovingViolation(testName, testDate,
        MovingViolationReason.DistractedDriving));
    movingList.add(new MovingViolation(testName, testDate,
        MovingViolationReason.DrivingUnderInfluence));
    movingList.add(new MovingViolation(testName, testDate,
        MovingViolationReason.Speeding));
    history = new DriverHistory(movingList, nonMovingList);
    assertFalse(registrationValidator.checkDriverHistory(history));
  }

  @Test
  public void checkVehicleHistory() throws Exception {
    assertTrue(registrationValidator.checkVehicleHistory(history2));
  }

  @Test
  public void checkVehicleHistoryFalse() throws Exception {
    crashList.add(new Crash(LocalDate.of(2019, 3, 2),
        CrashReason.CrashWithoutBodilyInjuries));
    movingList.add(new MovingViolation(testName, LocalDate.of(2019, 3, 5),
        MovingViolationReason.Speeding));
    assertFalse(registrationValidator.checkVehicleHistory(history2));
  }

  @Test
  public void equalsItself() throws Exception {
    assertTrue(registrationValidator.equals(registrationValidator));
  }

  @Test
  public void notEqualsNull() throws Exception {
    assertFalse(registrationValidator.equals(null));
  }

  @Test
  public void notEqualsAnotherClass() throws Exception {
    assertFalse(registrationValidator.equals(history));
  }

  @Test
  public void EqualsAnotherValidator() throws Exception {
    RegistrationValidator registrationValidator1 = new RegistrationValidator(
        new AcceptedPool(new HashMap<>()));
    assertEquals(registrationValidator1, registrationValidator);
  }

  @Test
  public void notEqualsAnotherValidator() throws Exception {
    AcceptedPool pool1 = new AcceptedPool(new HashMap<>());
    pool1.addDriver(driver, vehicle);
    RegistrationValidator registrationValidator1 = new RegistrationValidator(pool1);
    assertNotEquals(registrationValidator1, registrationValidator);
  }

  @Test
  public void equalsNullPool() throws Exception {
    RegistrationValidator registrationValidator1 = new RegistrationValidator(null);
    registrationValidator = new RegistrationValidator(null);
    assertEquals(registrationValidator1, registrationValidator);
  }

  @Test
  public void testHashCode() throws Exception {
    assertEquals(pool.hashCode(), registrationValidator.hashCode());
  }

  @Test
  public void testVoidHashCode() throws Exception {
    registrationValidator = new RegistrationValidator(null);
    assertEquals(0, registrationValidator.hashCode());
  }



  @Test
  public void testToString() throws Exception {
    assertEquals("RegistrationValidator{}", registrationValidator.toString());
  }

}