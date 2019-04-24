package edu.neu.ccs.cs5004.game.view.observer;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;

/**
 * Printer for the user's result.
 */
public class UserResultPrinter implements ResultObserver {
  /**
   * Print the result.
   *
   * @param result the result
   */
  public void update(AttackResult result) {
    System.out.println("You fired and ...");
    if (result.getClass() == AttackResult.createMiss().getClass()) {
      System.out.println("You missed!");
    } else if (result.getClass() == AttackResult.createHit().getClass()) {
      System.out.println("You hit a ship!");
    } else {
      System.out.println("You sunk a ship!");
    }
  }
}
