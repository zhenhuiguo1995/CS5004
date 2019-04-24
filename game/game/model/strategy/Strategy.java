package edu.neu.ccs.cs5004.game.model.strategy;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.player.Player;

/**
 * Represents a strategy to play battleship.
 */
public interface Strategy {
  /**
   * Creates a new user strategy.
   *
   * @return the new user strategy
   */
  static Strategy createUserStrategy() {
    return new UserStrategy();
  }

  /**
   * Creates a new random strategy.
   *
   * @return a new random strategy
   */
  static Strategy createRandomStrategy() {
    return new RandomStrategy();
  }

  /**
   * Creates a new smart strategy.
   *
   * @return a new smart strategy
   */
  static Strategy createSmartStrategy() {
    return new SmartStrategy();
  }

  /**
   * Fire and returns a result.
   *
   * @param user     the player
   * @param opponent the opponent
   * @return the hit result
   */
  AttackResult hitResult(Player user, Player opponent);
}
