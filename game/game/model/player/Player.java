package edu.neu.ccs.cs5004.game.model.player;

import edu.neu.ccs.cs5004.game.model.map.Map;
import edu.neu.ccs.cs5004.game.model.place.Place;

/**
 * Represents a player with details like fleet map and battle map.
 */
public interface Player {
  /* Create a new player. */
  static Player createNewPlayer(int[] number) {
    return new User(Map.createFleetMap(), Map.createBattleMap(), number);
  }

  /**
   * Gets the fleet configuration.
   *
   * @return the feet configuration
   */
  int[] getNumber();

  /**
   * Sets the fleet configuration as given.
   *
   * @param number the fleet configuration
   */
  void setNumber(int[] number);

  /**
   * Gets the fleet map.
   *
   * @return the fleet map
   */
  Map getFleetMap();

  /**
   * Gets the battle map.
   *
   * @return the battle map
   */
  Map getBattleMap();

  /**
   * Returns a new fleet map with ships placed.
   *
   * @param placement the user placement or the random placement
   */
  void placeShip(Place placement);
}
