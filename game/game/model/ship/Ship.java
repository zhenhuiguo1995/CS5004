package edu.neu.ccs.cs5004.game.model.ship;

/**
 * Represents a ship.
 */
public interface Ship {
  int BATTLE_SHIP_SIZE = 4;
  int CRUISER_SIZE = 3;
  int SUBMARINE_SIZE = 2;
  int DESTROYER_SIZE = 1;
  int ZERO = 0;

  /**
   * Update a ship if the ship is hit.
   */
  void hitShip();

  /**
   * Check if the ship has been sunk.
   *
   * @return true if the ship is sunk and false otherwise
   */
  Boolean isSunk();

  static Ship createBattleShip() {
    return new BattleShip(BATTLE_SHIP_SIZE, ZERO);
  }

  static Ship createCruiser() {
    return new Cruiser(CRUISER_SIZE, ZERO);
  }

  static Ship createSubmarine() {
    return new Submarine(SUBMARINE_SIZE, ZERO);
  }

  static Ship createDestroyer() {
    return new Destroyer(DESTROYER_SIZE, ZERO);
  }
}
