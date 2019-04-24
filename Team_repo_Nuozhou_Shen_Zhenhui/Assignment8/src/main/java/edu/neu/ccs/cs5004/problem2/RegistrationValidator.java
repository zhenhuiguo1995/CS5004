package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents details of a registration validator.
 */
public class RegistrationValidator {

  private static final int MINIMUM_AGE = 21;
  private static final int MINIMUM_DRIVING_DURATION = 6;
  private static final int VEHICLE_MAXIMUM_AGE = 20;
  private static final int MONTHS_IN_YEAR = 12;
  private static final int LAST_SIX_MONTHS = 6;

  private AcceptedPool pool;

  /**
   * Instantiates a new RegistrationValidator.
   *
   * @param pool -- AcceptedPool
   */
  public RegistrationValidator(AcceptedPool pool) {
    this.pool = pool;
  }

  /**
   * Validate if an applicant meets the selecting criterion.
   *
   * @param applicant the applicant
   * @return the boolean
   */
  public boolean validateApplicant(Applicant applicant) {
    int violationCount = 0;
    if (!checkAge(applicant.getDriver())) {
      violationCount ++ ;
    }
    if (!checkLicenseInformation(applicant.getDriver(), applicant.getDriverLicense())) {
      violationCount ++ ;
    }
    if (!checkVehicleInformation(applicant.getVehicle())) {
      violationCount ++ ;
    }
    if (!checkInsuranceInformation(applicant.getDriver(),
        applicant.getVehicle(), applicant.getInsurance())) {
      violationCount ++ ;
    }
    if (checkDriverHistory(applicant.getDriver().getHistory())
        && checkVehicleHistory(applicant.getVehicle().getVehicleHistory())) {
      violationCount ++ ;
    }
    if (violationCount == 0) {
      return pool.addDriver(applicant.getDriver(), applicant.getVehicle());
    } else {
      return false;
    }
  }

  /**
   * Check the age of the driver.
   *
   * @param driver the driver
   * @return the boolean
   */
  public boolean checkAge(Driver driver) {
    Period duration = Period.between(driver.getBirthday(), LocalDate.now());
    return duration.getYears() >= MINIMUM_AGE;
  }

  /**
   * Check the license information.
   *
   * @param driver the driver
   * @param driverLicense the driver license
   * @return the boolean
   */
  public boolean checkLicenseInformation(Driver driver, DriverLicense driverLicense) {
    int violationCount = 0;
    if (!isSameDriver(driver, driverLicense)) {
      violationCount ++ ;
    }
    if (!hasSameBirthday(driver, driverLicense)) {
      violationCount ++ ;
    }
    if (!checkLicenseIssuanceCountry(driverLicense)) {
      violationCount ++ ;
    }
    if (!checkDrivingDuration(driverLicense)) {
      violationCount ++ ;
    }
    if (!isLicenseValid(driverLicense)) {
      violationCount ++ ;
    }
    return violationCount == 0;
  }

  /**
   * Check if the driver name and the name on the license are the same.
   *
   * @param driver the driver
   * @param driverLicense the driver license
   * @return the boolean
   */
  private boolean isSameDriver(Driver driver, DriverLicense driverLicense) {
    return driver.getName().equals(driverLicense.getName());
  }

  /**
   * Check if the birthday of the driver and that on the driver license are the same.
   *
   * @param driver the driver
   * @param driverLicense the driver license
   * @return the boolean
   */
  private boolean hasSameBirthday(Driver driver, DriverLicense driverLicense) {
    // test to check the functionality
    return driver.getBirthday().isEqual(driverLicense.getBirthday());
  }

  /**
   * Check the license issuance country.
   *
   * @param driverLicense the driver license
   * @return the boolean
   */
  private boolean checkLicenseIssuanceCountry(DriverLicense driverLicense) {
    return driverLicense.getCountry().equals(Country.US);
  }

  /**
   * Check the driver's driving duration.
   *
   * @param driverLicense the driver license
   * @return the boolean
   */
  private boolean checkDrivingDuration(DriverLicense driverLicense) {
    Period duration = Period.between(driverLicense.getIssuanceDate(), LocalDate.now());
    return duration.getYears() * MONTHS_IN_YEAR + duration.getMonths() >= MINIMUM_DRIVING_DURATION;
  }

  /**
   * Checks if the driver license is valid now.
   *
   * @param driverLicense the driver license
   * @return the boolean
   */
  private boolean isLicenseValid(DriverLicense driverLicense) {
    // more test to be run
    return driverLicense.getExpirationDate().isAfter(LocalDate.now());
  }

  /**
   * Check the vehicle information.
   *
   * @param vehicle the vehicle
   * @return the boolean
   */
  public boolean checkVehicleInformation(Vehicle vehicle) {
    return LocalDate.now().getYear() - vehicle.getYear() < VEHICLE_MAXIMUM_AGE;
  }


  /**
   * Check the insurance information.
   *
   * @param driver the driver
   * @param vehicle the vehicle
   * @param insurance the insurance
   * @return the boolean
   */
  public boolean checkInsuranceInformation(Driver driver, Vehicle vehicle, Insurance insurance) {
    int violationCount = 0;
    if (!(isOfficialOwner(driver, vehicle)) && !isInsuredDriver(driver, insurance)) {
      violationCount ++;
    }
    if (!isInsuranceValid(insurance)) {
      violationCount ++ ;
    }
    return violationCount == 0;
  }

  /**
   * Check if the driver is the official owner of the vehicle.
   *
   * @param driver the driver
   * @param vehicle the vehicle
   * @return the boolean
   */
  private boolean isOfficialOwner(Driver driver, Vehicle vehicle) {
    return driver.getName().equals(vehicle.getOwner().getName())
        && driver.getBirthday().isEqual(vehicle.getOwner().getBirthday());
  }

  /**
   * Check if the driver is an insured driver on the insurance.
   *
   * @param driver the driver
   * @param insurance the insurance
   * @return the boolean
   */
  private boolean isInsuredDriver(Driver driver, Insurance insurance) {
    Person person = new Person(driver.getName(), driver.getBirthday());
    for (Person insuredPerson : insurance.getCoverList()) {
      if (person.equals(insuredPerson)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Check if the insurance is valid.
   *
   * @param insurance the insurance
   * @return the boolean
   */
  private boolean isInsuranceValid(Insurance insurance) {
    return insurance.getExpirationDate().isAfter(LocalDate.now());
  }


  /**
   * Check the driver's history, including moving violation history.
   *
   * @param driverHistory the driver history
   * @return the boolean
   */
  public boolean checkDriverHistory(DriverHistory driverHistory) {
    if (driverHistory.getMovingViolationList().size() != 0) {
      Set<MovingViolationReason> violationReasons = new HashSet<>();
      for (MovingViolation movingViolation : driverHistory.getMovingViolationList()) {
        violationReasons.add(movingViolation.getViolation());
      }
      int violationCount = 0;
      if (violationReasons.contains(MovingViolationReason.DistractedDriving)) {
        violationCount ++ ;
      }
      if (violationReasons.contains(MovingViolationReason.Speeding)) {
        violationCount ++ ;
      }
      if (violationReasons.contains(MovingViolationReason.DrivingUnderInfluence)) {
        violationCount ++ ;
      }
      if (violationReasons.contains(MovingViolationReason.DrivingWithoutValidLicenseOrInsurance)) {
        violationCount ++ ;
      }
      return violationCount == 0;
    }
    return true;
  }

  /**
   * Check the vehicle history, including moving violation history and crash history.
   *
   * @param vehicleHistory the vehicle history
   * @return the boolean
   */
  public boolean checkVehicleHistory(VehicleHistory vehicleHistory) {
    Period duration;
    int violationCount = 0;
    for (Crash crash : vehicleHistory.getCrashList()) {
      duration = Period.between(crash.getDate(), LocalDate.now());
      if (duration.getYears() * MONTHS_IN_YEAR + duration.getMonths() < LAST_SIX_MONTHS) {
        violationCount ++;
      }
    }
    for (MovingViolation movingViolation : vehicleHistory.getMovingViolationList()) {
      duration = Period.between(movingViolation.getDate(), LocalDate.now());
      if (duration.getYears() * MONTHS_IN_YEAR + duration.getMonths() < LAST_SIX_MONTHS) {
        violationCount ++;
      }
    }
    return violationCount == 0;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    RegistrationValidator that = (RegistrationValidator) object;

    return pool != null ? pool.equals(that.pool) : that.pool == null;
  }

  @Override
  public int hashCode() {
    return pool != null ? pool.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "RegistrationValidator{}";
  }
}