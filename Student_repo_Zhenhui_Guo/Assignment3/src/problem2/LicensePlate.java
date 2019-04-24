package problem2;

/**
 * Represents detailed information of a license plate, including state, license number and expire
 * date.
 */
public class LicensePlate {
  private State state;
  private String licenseNumber;
  private Date expireDate;

  /**
   * Creates a license plate given state
   *
   * @param state the state information.
   * @param licenseNumber the license number of the vehicle.
   * @param expireDate the expire date of the vehicle.
   */
  public LicensePlate(State state, String licenseNumber, Date expireDate) {
    this.state = state;
    this.licenseNumber = licenseNumber;
    this.expireDate = expireDate;
  }

  /**
   * Gets state.
   *
   * @return the state.
   */
  public State getState() {
    return state;
  }

  /**
   * Gets license number.
   *
   * @return the license number.
   */
  public String getLicenseNumber() {
    return licenseNumber;
  }

  /**
   * Gets expire date.
   *
   * @return the expire date.
   */
  public Date getExpireDate() {
    return expireDate;
  }
}
