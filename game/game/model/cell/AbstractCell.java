package edu.neu.ccs.cs5004.game.model.cell;

import java.util.Objects;

/**
 * Represents an abstract cell in the mode world.
 */
abstract class AbstractCell implements Cell {
  protected Boolean isHit;

  /**
   * Creates a new AbstractCell with given property.
   *
   * @param isHit the value of is hit
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
  }

  /**
   * Check if the cell is hit.
   *
   * @return true if the cell is hit and false otherwise
   */
  public Boolean getIsHit() {
    return this.isHit;
  }

  /**
   * Update a cell if the cell has been attacked.
   */
  public void attackCell() {
    this.isHit = true;
  }

  @Override
  public boolean isHited() {
    return isHit;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractCell that = (AbstractCell) obj;
    return Objects.equals(isHit, that.isHit);
  }

  @Override
  public int hashCode() {

    return Objects.hash(isHit);
  }
}
