package edu.neu.ccs.cs5004.game.model.place;

import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Randomly choose the top left cell of the ship and the direction of the ship.
 */
class RandomPlace extends AbstractPlace {
  // public static final int HORIZON = 0;
  // public static final int VERTICAL = 1;
  public static final int BATTLE_SHIP_SIZE = 4;
  public static final int CRUISER_SIZE = 3;
  public static final int SUBMARINE_SIZE = 2;
  public static final int DESTROYER_SIZE = 1;

  /**
   * Place the ships appropriately based on the given player.
   *
   * @param player the player who wants to choose place his ships randomly
   */
  public void actualPlace(Player player) {
    //player.setFleetMap(new map());
    placeShip(BATTLE_SHIP_SIZE, 0, player);
    placeShip(CRUISER_SIZE, 1, player);
    placeShip(SUBMARINE_SIZE, 2, player);
    placeShip(DESTROYER_SIZE, 3, player);

  }

  /**
   * Place the ship by giving player and ship's property.
   *
   * @param size        the size of ship which we want to place
   * @param indexOfShip the index of ship's type
   * @param player      the player who wants to place ship
   */
  public void placeShip(int size, int indexOfShip, Player player) {
    int[] ddNumber = player.getNumber();
    for (int i = 0; i < ddNumber[indexOfShip]; i++) {
      int direction = ThreadLocalRandom.current().nextInt(HORIZON, VERTICAL + 1);
      int row = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
      int col = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
      while (!legalPlace(Row.values()[row], Column.values()[col], size, direction, player)) {
        row = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
        col = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
        direction = ThreadLocalRandom.current().nextInt(HORIZON, VERTICAL + 1);
      }
      if (direction == HORIZON) {
        placeColumn(row, col, size, indexOfShip, player);
      }
      if (direction == VERTICAL) {
        placeRow(row, col, size, indexOfShip, player);
      }
      markGapCell(Row.values()[row], Column.values()[col], direction, size, player);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 19;
  }
}
