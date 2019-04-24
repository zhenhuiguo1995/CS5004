package edu.neu.ccs.cs5004.game.controller;

import edu.neu.ccs.cs5004.game.model.mode.Mode;
import edu.neu.ccs.cs5004.game.view.Interaction;

/**
 * Represents the controller which uses model according to user's inputs.
 */
class GameController implements Controller{
  /**
   * Represents the game controller.
   */
  public GameController() {
    System.out.println("Welcome to BattleShip Game!");
    String mode = Interaction.readGameMode();
    Mode game = null;
    if (mode.equals("D")) {
      game = Mode.createDebugMode();
    } else {
      game = Mode.createGameMode();
    }
    game.setUpPlayerShips();
    game.setUpComputerShips();
    game.startBattle();
    System.out.println("Game Over!");
  }
}
