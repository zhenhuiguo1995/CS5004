package edu.neu.ccs.cs5004.game.model.place;

import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;
import edu.neu.ccs.cs5004.game.view.Interaction;

/**
 * Represents a way to place ships whose locations and directions are determined by the user.
 */
class UserPlace extends AbstractPlace {
  private static final int HORIZON = 0;
  private static final int VERTICAL = 1;

  /**
   * Ship placement process.
   *
   * @param player one player in the game.
   */
  public void actualPlace(Player player) {
    int[] array = player.getNumber();
    for (int i = 0; i < 4; i++) {
      innerPlace(array[i], i, player);
    }
  }

  /**
   * Inner ship placement process.
   *
   * @param number the number of one specific ship.
   * @param index  the specific ship's index. Battleship's index is 0, Cruiser's index is 1,
   *               Submarine's index is 2, Destroyer's index is 3.
   * @param player a player in the game.
   */
  public void innerPlace(int number, int index, Player player) {

    for (int j = 0; j < number; j++) {
      int direction;
      Row row;
      Column column;

      while (true) {
        String rowString = Interaction.getRowString();
        row = Row.values()[Integer.parseInt(rowString) - 1];

        String colSting = Interaction.getColumnString();
        column = Column.values()[colSting.charAt(0) - 'A'];

        String dirString = Interaction.getDirectionString();
        direction = dirString.equals("Horizon") ? HORIZON : VERTICAL;

        if (legalPlace(row, column, 4 - index, direction, player)) {
          break;
        } else {
          System.out.println("Cannot fit the ship in the map! "
              + "Please re-enter position and direction.");
        }
      }
      if (direction == HORIZON) {
        placeColumn(row.ordinal(), column.ordinal(), 4 - index, index, player);
      } else {
        placeRow(row.ordinal(), column.ordinal(), 4 - index, index, player);
      }
      markGapCell(row, column, direction, 4 - index, player);
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
    return 17;
  }
}
