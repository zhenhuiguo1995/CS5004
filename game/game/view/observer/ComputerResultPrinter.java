package edu.neu.ccs.cs5004.game.view.observer;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;

/**
 * Printer for the computer's result.
 */
public class ComputerResultPrinter implements ResultObserver {
  /**
   * Print the result.
   *
   * @param result the result
   */
  public void update(AttackResult result) {
    System.out.println("Computer fired and ...");
    if (result.getClass() == AttackResult.createMiss().getClass()) {
      System.out.println("Computer missed!");
    } else if (result.getClass() == AttackResult.createHit().getClass()) {
      System.out.println("Computer hit a ship!");
    } else {
      System.out.println("Computer sunk a ship!");
    }
  }
}