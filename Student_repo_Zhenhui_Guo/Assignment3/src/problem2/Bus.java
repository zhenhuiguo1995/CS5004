package problem2;

/**
 * Represents details of a bus object, including max allowed velocity and other inherited fields.
 */
public class Bus extends AbstractVehicle {
  static final int MAX_VELOCITY = 60;

  /**
   * Instantiates a new Bus.
   *
   * @param color the color
   * @param makeAndModel the make and model
   * @param velocity the velocity
   * @param direction the direction
   */
  public Bus(String color, MakeAndModel makeAndModel, double velocity,
      DIRECTION direction) throws Exception {
    super(color, makeAndModel, velocity, direction, MAX_VELOCITY);
  }

  /**
   * Creates a new bus.
   *
   * @param velocity the velocity
   * @param nextDirection the next direction
   * @return
   */
  @Override
  public AbstractVehicle create(double velocity, DIRECTION nextDirection) throws Exception {
    return new Bus(this.getColor(), this.getMakeAndModel(),
        velocity, nextDirection);
  }
}
