package edu.neu.ccs.cs5004.game.model.cell;

/**
 * Represents a open sea water cell.
 */
class OpenSeaWaterCell extends AbstractWaterCell {

  /**
   * Creates a new AbstractCell with given property.
   *
   * @param isHit the value of is hit
   */
  public OpenSeaWaterCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Check if the cell can put a ship.
   *
   * @return true because cell that has no adjacent ship cell
   */
  public Boolean placeShipOnCell() {
    return true;
  }

  @Override
  public int hashCode() {
    return 23;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
