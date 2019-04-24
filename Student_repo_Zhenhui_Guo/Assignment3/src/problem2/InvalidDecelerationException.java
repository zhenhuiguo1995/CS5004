package problem2;

/**
 * The type Invalid deceleration exception.
 */
public class InvalidDecelerationException extends Exception{
  private double velocity;

  /**
   * Instantiates a new Invalid deceleration exception.
   *
   * @param velocity the velocity
   */
  public InvalidDecelerationException(double velocity) {
    this.velocity = velocity;
  }

  /**
   * Gets velocity.
   *
   * @return the velocity
   */
  public double getVelocity() {
    return this.velocity;
  }
}
