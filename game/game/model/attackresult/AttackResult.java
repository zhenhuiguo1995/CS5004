package edu.neu.ccs.cs5004.game.model.attackresult;

/**
 * Represents an attack result.
 */
public interface AttackResult {
  /**
   * Creates a new miss.
   *
   * @return miss
   */
  static AttackResult createMiss() {
    return new Miss();
  }

  /**
   * Creates a new sunk.
   *
   * @return sunk
   */
  static AttackResult createSunk() {
    return new Sunk();
  }

  /**
   * Creates a new hit.
   *
   * @return hit
   */
  static AttackResult createHit() {
    return new Hit();
  }
}
