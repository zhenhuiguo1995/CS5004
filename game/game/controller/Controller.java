package edu.neu.ccs.cs5004.game.controller;

/**
 * Represents the game controller.
 */
public interface Controller {
  /**
   * Create a new game controller.
   * @return a game controller.
   */
  static Controller createNewController() {
    return new GameController();
  }
}
