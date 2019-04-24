package edu.neu.ccs.cs5004.game.model.place;

import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;

/**
 * Represents place.
 */
public interface Place {
  /**
   * Check if if can place the cell legally.
   * @param row the row value
   * @param column the column value
   * @param size the size of the ship
   * @param direction the direction of the ship
   * @param player the player who wants to place the cell
   * @return true if this place is legal and false otherwise
   */
  boolean legalPlace(Row row, Column column, int size, int direction, Player player);

  /**
   * Mark the gap cell.
   * @param row the row value
   * @param column the column value
   * @param direction the direction of the ship
   * @param size the size of ship
   * @param player the player
   */
  void markGapCell(Row row, Column column, int direction, int size, Player player);

  /**
   * Create random place.
   * @return random place
   */
  static Place createRandomPlace() {
    return new RandomPlace();
  }
  /**
   * Create user place.
   * @return user place
   */
  static Place createUserPlace() {
    return new UserPlace();
  }

  /**
   * Actual place.
   * @param player the player
   */
  void actualPlace(Player player);
}
