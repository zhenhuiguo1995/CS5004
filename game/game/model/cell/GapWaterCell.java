package edu.neu.ccs.cs5004.game.model.cell;

/**
 * Represents a gap water cell.
 */
class GapWaterCell extends AbstractWaterCell {
  /**
   * Creates a new AbstractCell with given property.
   *
   * @param isHit the value of is hit
   */
  public GapWaterCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Check if the cell can put a ship.
   *
   * @return false because cell that has at least one adjacent ship cell
   */
  public Boolean placeShipOnCell() {
    return false;
  }

  @Override
  public int hashCode() {
    return 17;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
