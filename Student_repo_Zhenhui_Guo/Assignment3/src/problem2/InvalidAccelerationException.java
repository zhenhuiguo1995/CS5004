package problem2;

/**
 * The type Invalid acceleration exception.
 */
public class InvalidAccelerationException extends Exception {
  private double velocity;

  /**
   * Instantiates a new Invalid acceleration exception.
   *
   * @param newVelocity the new velocity
   */
  public InvalidAccelerationException(double newVelocity) {
    this.velocity = newVelocity;
  }

  /**
   * Gets velocity.
   *
   * @return the velocity
   */
  public double getVelocity() {
    return velocity;
  }
}
