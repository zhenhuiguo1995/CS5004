package edu.neu.ccs.cs5004.game.model.cell;

import java.util.Objects;

/**
 * Represents  an abstract ship cell.
 */
abstract class AbstractShipCell extends AbstractCell implements ShipCell {
  protected Boolean isSunk;

  /**
   * Creates a new AbstractShipCell with given property.
   *
   * @param isHit  the state of the ship cell is hit or not
   * @param isSunk the state of the ship cell is sunk or not
   */
  public AbstractShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit);
    this.isSunk = isSunk;
  }

  /**
   * Get the property of isSunk of the ship cell.
   *
   * @return the value of isSunk of the ship cell
   */
  public Boolean getIsSunk() {
    return this.isSunk;
  }

  /**
   * Check if the cell can be placed a ship.
   *
   * @return false because this ship has already been placed a ship
   */
  public Boolean placeShipOnCell() {
    return false;
  }

  /**
   * Mark the ship if the ship is sunk.
   *
   * @return an updated ship cell with sunk mark if it is sunk, otherwise no changes
   */
  public abstract ShipCell markShipCellSunk();

  @Override
  public boolean isSunked() {
    return isSunk;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    AbstractShipCell that = (AbstractShipCell) obj;
    return Objects.equals(isSunk, that.isSunk);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), isSunk);
  }
}
