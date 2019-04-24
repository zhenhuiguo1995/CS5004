package edu.neu.ccs.cs5004.game.model.cell;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.ship.Ship;

/**
 * Represents a cell in the mode.
 */
public interface Cell {
  /**
   * Check if the cell can be placed a ship.
   *
   * @return true if can be placed and false otherwise
   */
  Boolean placeShipOnCell();

  /**
   * Update a cell if the cell has been attacked.
   */
  void attackCell();

  /**
   * Get the attack result.
   *
   * @return hit, sunk or miss
   */
  AttackResult attackResult();

  /**
   * Creates a new OpenSeaWaterCell.
   *
   * @return a new OpenSeaWaterCell
   */
  static Cell createOpenSeaWaterCell() {
    return new OpenSeaWaterCell(false);
  }

  /**
   * Creates a new GapWaterCell.
   *
   * @return a new GapWaterCell
   */
  static Cell createGapWasterCell() {
    return new GapWaterCell(false);
  }

  /**
   * Creates a new specific ship cell by given ship.
   *
   * @param ship the ship which we want to put
   * @return a new specific ship cell
   */
  static Cell createSpecificShipCell(Ship ship) {
    return new SpecificShipCell(false, false, ship);
  }

  /**
   * Creates a new enemy ship cell.
   *
   * @return a new enemy ship cell
   */
  static Cell createEnemyShipCell() {
    return new EnemyShipCell(false, false);
  }

  /**
   * Check if the cell is hit.
   *
   * @return true if the cell is hit, otherwise false.
   */
  boolean isHited();

  /**
   * Check if the cell is sunk.
   *
   * @return true if the cell is hit, otherwise false.
   */
  boolean isSunked();

}
