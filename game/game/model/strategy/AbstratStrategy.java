package edu.neu.ccs.cs5004.game.model.strategy;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.player.Player;

/**
 * Represents an abstract strategy.
 */
abstract class AbstratStrategy implements Strategy {

  /**
   * Fire and returns a result.
   *
   * @param user     the player.
   * @param opponent the opponent.
   * @return the hit result.
   */
  public abstract AttackResult hitResult(Player user, Player opponent);
}
