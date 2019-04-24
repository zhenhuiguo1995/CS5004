package edu.neu.ccs.cs5004.game.model.cell;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;

/**
 * Represents an abstract water cell in the mode world.
 */
abstract class AbstractWaterCell extends AbstractCell implements WaterCell {
  /**
   * Creates a new AbstractCell with given property.
   *
   * @param isHit the value of is hit
   */
  public AbstractWaterCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Return the attack result.
   *
   * @return Miss because it hits the water cell
   */
  public AttackResult attackResult() {
    return AttackResult.createMiss();
  }

  @Override
  public boolean isSunked() {
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
