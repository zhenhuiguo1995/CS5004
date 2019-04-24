package edu.neu.ccs.cs5004.game.model.ship;

import java.util.Objects;

/**
 * Represents  an abstract ship.
 */
abstract class AbstractShip implements Ship {
  private Integer size;
  private Integer numberOfHitCells;

  /**
   * Creates a new AbstractShip by given size and numberOfHitCells.
   *
   * @param size             the size of the AbstractShip
   * @param numberOfHitCells the numberOfHitCells of the AbstractShip
   */
  public AbstractShip(Integer size, Integer numberOfHitCells) {
    this.size = size;
    this.numberOfHitCells = numberOfHitCells;
  }

  /**
   * Get the property of size.
   *
   * @return the size of the ship
   */
  public Integer getSize() {
    return this.size;
  }

  /**
   * Get the property of numberOfHitCells.
   *
   * @return the number of hit cells of the ship
   */
  public Integer getNumberOfHitCells() {
    return this.numberOfHitCells;
  }

  /**
   * Check if the ship is sunk.
   *
   * @return true if the ship is sunk and false otherwise
   */
  public Boolean isSunk() {
    return size.equals(numberOfHitCells);
  }

  /**
   * Update a ship if the ship is hit.
   */
  public void hitShip() {
    this.numberOfHitCells += 1;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractShip that = (AbstractShip) obj;
    return Objects.equals(size, that.size)
        && Objects.equals(numberOfHitCells, that.numberOfHitCells);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, numberOfHitCells);
  }
}
