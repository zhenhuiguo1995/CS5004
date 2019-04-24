package edu.neu.ccs.cs5004.game.model.cell;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.ship.Ship;

import java.util.Objects;


/**
 * Represents a specific ship cell.
 */
class SpecificShipCell extends AbstractShipCell {
  private Ship ship;

  /**
   * Creates a new specific ship cell with given ship.
   *
   * @param isHit  the state of the ship cell is hit or not
   * @param isSunk the state of the ship cell is sunk or not
   * @param ship   the ship we want to pass to the ship cell
   */
  public SpecificShipCell(Boolean isHit, Boolean isSunk, Ship ship) {
    super(isHit, isSunk);
    this.ship = ship;
  }

  /**
   * update the ship and the ship cell if it is hit.
   */
  @Override
  public void attackCell() {
    ship.hitShip();
    this.isHit = true;
  }

  public ShipCell markShipCellSunk() {
    return new SpecificShipCell(true, true, this.ship);
  }

  /**
   * Get the attack result.
   *
   * @return hit, sunk or miss
   */
  public AttackResult attackResult() {
    if (this.ship.isSunk()) {
      return AttackResult.createSunk();
    } else {
      return AttackResult.createHit();
    }
  }

  /**
   * Get the property of the specific ship cell.
   *
   * @return the ship
   */
  public Ship getShip() {
    return this.ship;
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
    SpecificShipCell that = (SpecificShipCell) obj;
    return Objects.equals(ship, that.ship);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), ship);
  }
}
