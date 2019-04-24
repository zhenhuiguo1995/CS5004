package edu.neu.ccs.cs5004.game;

import edu.neu.ccs.cs5004.game.controller.Controller;

/**
 * Represents a battleship game.
 */
class ActualGame implements Game{
  Controller controller;

  /**
   * Constructor for battleship game.
   */
  public ActualGame() {
    controller = Controller.createNewController();
  }
}
