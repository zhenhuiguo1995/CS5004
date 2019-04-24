package problem2;

/**
 * Represents details of an automobile, including max allowed velocity and other inherited fields.
 */
public class Automobile extends AbstractVehicle {
  private static final int MAX_VELOCITY = 70;

  /**
   * Instantiates a new Automobile.
   *
   * @param color the color
   * @param makeAndModel the make and model
   * @param velocity the velocity
   * @param direction the direction
   */
  public Automobile(String color, MakeAndModel makeAndModel, double velocity,
      DIRECTION direction) throws Exception {
    super(color, makeAndModel, velocity, direction, MAX_VELOCITY);
  }

  @Override
  public AbstractVehicle create(double velocity, DIRECTION nextDirection) throws Exception {
    return new Automobile(this.getColor(), this.getMakeAndModel(),
        velocity, nextDirection);
  }
}
