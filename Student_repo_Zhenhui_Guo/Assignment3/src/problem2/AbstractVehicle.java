package problem2;

/**
 * Represents detailed information of a vehicle, including color, current velocity, max allowed
 * velocity, min allowed velocity, and current direction
 */
public abstract class AbstractVehicle {
  private static final int PERCENT = 100;
  private static final int MIN_VELOCITY = 40;
  private static final int MIN_ACCELERATION_FACTOR = 10;
  private static final int MAX_ACCELERATION_FACTOR = 50;
  private static final int MIN_DECELERATION_FACTOR = 20;
  private static final int MAX_DECELERATION_FACTOR = 50;
  private String color;
  private MakeAndModel makeAndModel;
  private double velocity;
  private int maxVelocity;
  private DIRECTION direction;

  /**
   * Instantiates a new Abstract vehicle.
   *
   * @param color the color
   * @param makeAndModel the make and model
   * @param velocity the velocity
   * @param direction the direction
   * @param maxVelocity the max velocity
   */
  public AbstractVehicle(String color, MakeAndModel makeAndModel, double velocity,
      DIRECTION direction, int maxVelocity) throws Exception {
    if (velocity < MIN_VELOCITY || velocity > maxVelocity) {
      throw new IllegalArgumentException("Velocicity must be of legal range!");
    } else {
      this.color = color;
      this.makeAndModel = makeAndModel;
      this.velocity = velocity;
      this.direction = direction;
      this.maxVelocity = maxVelocity;
    }
  }

  /**
   * Create abstract vehicle.
   *
   * @param velocity the velocity
   * @param nextDirection the next direction
   * @return the abstract vehicle
   */
  public abstract AbstractVehicle create(double velocity, DIRECTION nextDirection) throws Exception;

  /**
   * Accelerate abstract vehicle.
   *
   * @param accelerationFactor the acceleration factor
   * @return the abstract vehicle
   * @throws Exception the exception
   */
  public AbstractVehicle accelerate(int accelerationFactor) throws Exception {
    if (accelerationFactor < MIN_ACCELERATION_FACTOR ||
        accelerationFactor > MAX_ACCELERATION_FACTOR) {
      throw new IllegalArgumentException("Acceleration factor must be from " +
          MIN_ACCELERATION_FACTOR + " to " + MAX_ACCELERATION_FACTOR );
    } else {
      double newVelocity = this.velocity * (1 + (double)accelerationFactor/PERCENT);
      if (newVelocity > this.maxVelocity) {
        throw new InvalidAccelerationException(newVelocity);
      } else {
        return create(newVelocity, this.direction) ;
      }
    }
  }

  /**
   * Decelerate abstract vehicle.
   *
   * @param decelerationFactor the deceleration factor
   * @return the abstract vehicle
   * @throws InvalidDecelerationException the invalid deceleration exception
   */
  public AbstractVehicle decelerate(int decelerationFactor) throws Exception {
    if (decelerationFactor < MIN_DECELERATION_FACTOR ||
        decelerationFactor > MAX_DECELERATION_FACTOR) {
      throw new IllegalArgumentException("Deceleration factor must be from " +
          MIN_DECELERATION_FACTOR + " to " + MAX_DECELERATION_FACTOR);
    } else {
      double newVelocity = this.velocity * (1 - (double) decelerationFactor/PERCENT);
      if (newVelocity < MIN_VELOCITY) {
        throw new InvalidDecelerationException(newVelocity);
      } else {
        return create(newVelocity, this.direction);
      }
    }
  }

  /**
   * Change the direction of the abstract vehicle.
   *
   * @param nextDirection the next direction
   * @return the abstract vehicle
   * @throws InvalidDirectionException the invalid direction exception
   */
  public AbstractVehicle directionChange (DIRECTION nextDirection) throws Exception
  {
    if ((this.direction == DIRECTION.EASTBOUND && nextDirection == DIRECTION.WESTBOUND) ||
        (this.direction == DIRECTION.WESTBOUND && nextDirection == DIRECTION.EASTBOUND) ||
        (this.direction == DIRECTION.SOUTHBOUND && nextDirection == DIRECTION.NORTHBOUND) ||
        (this.direction == DIRECTION.NORTHBOUND && nextDirection == DIRECTION.SOUTHBOUND)) {
      return create(this.velocity, nextDirection);
    } else {
      throw new InvalidDirectionException(this.direction, nextDirection);
    }
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  public String getColor() {
    return color;
  }

  /**
   * Gets make and model.
   *
   * @return the make and model
   */
  public MakeAndModel getMakeAndModel() {
    return makeAndModel;
  }

  /**
   * Gets velocity.
   *
   * @return the velocity
   */
  public double getVelocity() {
    return velocity;
  }

  /**
   * Gets direction.
   *
   * @return the direction
   */
  public DIRECTION getDirection() {
    return direction;
  }

  /**
   * Gets max velocity.
   *
   * @return the max velocity
   */
  public int getMaxVelocity() {
    return maxVelocity;
  }
}
