package edu.neu.ccs.cs5004.game.model.cell;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;

/**
 * Represents an enemy ship cell.
 */
class EnemyShipCell extends AbstractShipCell {

  /**
   * Creates a new AbstractShipCell with given property.
   *
   * @param isHit  the state of the ship cell is hit or not
   * @param isSunk the state of the ship cell is sunk or not
   */
  public EnemyShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit, isSunk);
  }


  public ShipCell markShipCellSunk() {
    return new EnemyShipCell(true, true);
  }


  public AttackResult attackResult() {
    return AttackResult.createMiss();
  }


  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

}
