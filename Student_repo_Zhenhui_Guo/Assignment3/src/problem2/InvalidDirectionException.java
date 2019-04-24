package problem2;

/**
 * Represents details of an invalid direction exception
 */
public class InvalidDirectionException extends Exception{
  private DIRECTION currentDirection;
  private DIRECTION nextDirection;

  /**
   * Instantiates a new Invalid direction exception.
   *
   * @param currentDirection the current direction
   * @param nextDirection the next direction
   */
  public InvalidDirectionException(DIRECTION currentDirection, DIRECTION nextDirection) {
    this.currentDirection = currentDirection;
    this.nextDirection = nextDirection;
  }

  /**
   * Gets current direction.
   *
   * @return the current direction.
   */
  public DIRECTION getCurrentDirection() {
    return currentDirection;
  }

  /**
   * Gets next direction.
   *
   * @return the next direction to be turned.
   */
  public DIRECTION getNextDirection() {
    return nextDirection;
  }
}
