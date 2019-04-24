package edu.neu.ccs.cs5004.game.model.cell;

/**
 * Represents a ship cell.
 */
public interface ShipCell {
  /**
   * Mark the ship if the ship is sunk.
   *
   * @return an updated ship cell with sunk mark if it is sunk, otherwise no changes
   */
  ShipCell markShipCellSunk();

}
