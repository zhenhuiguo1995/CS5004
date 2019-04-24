package problem2;

/**
 * Represents details of a motocycle, including max allowed velocity and other inherited fields.
 */
public class Motorcycle extends AbstractVehicle {
  private static final int MAX_VELOCITY = 65;

  /**
   * Instantiates a new Motorcycle.
   *
   * @param color the color
   * @param makeAndModel the make and model
   * @param velocity the velocity
   * @param direction the direction
   */
  public Motorcycle(String color, MakeAndModel makeAndModel, double velocity,
      DIRECTION direction) throws Exception {
    super(color, makeAndModel, velocity, direction, MAX_VELOCITY);
  }

  @Override
  public AbstractVehicle create(double velocity, DIRECTION nextDirection) throws Exception {
    return new Motorcycle(this.getColor(), this.getMakeAndModel(),velocity,
        nextDirection);
  }
}
