package edu.neu.ccs.cs5004.game.model.attackresult;

/**
 * Represents Sunk.
 */
class Sunk implements AttackResult {
  @Override
  public int hashCode() {
    return 7;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      return true;
    }
  }
}
