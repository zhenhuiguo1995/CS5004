package edu.neu.ccs.cs5004.game.model.attackresult;

/**
 * Represents Hit.
 */
class Hit implements AttackResult {
  @Override
  public int hashCode() {
    return 37;
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
