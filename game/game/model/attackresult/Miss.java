package edu.neu.ccs.cs5004.game.model.attackresult;

/**
 * Represents Miss.
 */
class Miss implements AttackResult {
  @Override
  public int hashCode() {
    return 23;
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
