package problem2;

/**
 * Represents details of a truck, including max allowed velocity and other inherited fields.
 */
public class Truck extends AbstractVehicle {
  private static final int MAX_VELOCITY = 60;

  /**
   * Instantiates a new Truck.
   *
   * @param color the color
   * @param makeAndModel the make and model
   * @param velocity the velocity
   * @param direction the direction
   */
  public Truck(String color, MakeAndModel makeAndModel, double velocity,
      DIRECTION direction) throws Exception {
    super(color, makeAndModel, velocity, direction, MAX_VELOCITY);
  }

  @Override
  public AbstractVehicle create(double velocity, DIRECTION nextDirection) throws Exception {
    return new Truck(this.getColor(), this.getMakeAndModel(),
        velocity, nextDirection);
  }
}
