package edu.neu.ccs.cs5004.game.model.place;


import edu.neu.ccs.cs5004.game.model.cell.Cell;
import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;
import edu.neu.ccs.cs5004.game.model.ship.Ship;

abstract class AbstractPlace implements Place {
  public static final int HORIZON = 0;
  public static final int VERTICAL = 1;
  protected static final int ROW_OF_MAP = 10;
  protected static final int COLUMN_OF_MAP = 10;


  /**
   * Check if this place is legal for placing ship.
   *
   * @param rowNumber    the row value which we want to place ship
   * @param columnNumber the column value which we want to place ship
   * @param size         the size of the ship
   * @param direction    the direction of the ship
   * @param player       the player who wants to place ship
   * @return true if this place is legal and false otherwise
   */
  public boolean legalPlace(Row rowNumber, Column columnNumber,
                            int size, int direction, Player player) {
    if (rowNumber.ordinal() + size <= ROW_OF_MAP && direction == VERTICAL) {
      int row = rowNumber.ordinal();
      for (; row < rowNumber.ordinal() + size; row++) {
        if (player.getFleetMap().getCell(Row.values()[row], columnNumber).getClass()
            != Cell.createOpenSeaWaterCell().getClass()) {
          return false;
        }
      }
      return true;
    }
    if (columnNumber.ordinal() + size <= COLUMN_OF_MAP && direction == HORIZON) {
      int column = columnNumber.ordinal();
      for (; column < columnNumber.ordinal() + size; column++) {
        if (player.getFleetMap().getCell(rowNumber, Column.values()[column]).getClass()
            != Cell.createOpenSeaWaterCell().getClass()) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  /**
   * Set the surrounding cells as GapWaterCell.
   *
   * @param rowNumber    the row value which we want to place
   * @param columnNumber the column value which we want to place
   * @param direction    the direction of our ship
   * @param size         the size of ship which we are going to place
   * @param player       the player who wants to place ship
   */
  public void markGapCell(Row rowNumber, Column columnNumber,
                          int direction, int size, Player player) {
    if (direction == HORIZON) {
      for (int column = columnNumber.ordinal();
           column < columnNumber.ordinal() + size; column++) {
        if (rowNumber.ordinal() - 1 >= 0) {
          player.getFleetMap().setCell(Row.values()[rowNumber.ordinal() - 1],
              Column.values()[column],
              Cell.createGapWasterCell());
        }
        if (rowNumber.ordinal() + 1 < ROW_OF_MAP) {
          player.getFleetMap().setCell(Row.values()[rowNumber.ordinal() + 1],
              Column.values()[column],
              Cell.createGapWasterCell());
        }
      }
      if (columnNumber.ordinal() + size < COLUMN_OF_MAP) {
        player.getFleetMap().setCell(rowNumber, Column.values()[columnNumber.ordinal() + size],
            Cell.createGapWasterCell());
      }
      if (columnNumber.ordinal() - 1 >= 0) {
        player.getFleetMap().setCell(rowNumber, Column.values()[columnNumber.ordinal() - 1],
            Cell.createGapWasterCell());
      }
    }

    if (direction == VERTICAL) {
      for (int row = rowNumber.ordinal(); row < rowNumber.ordinal() + size; row++) {
        if (columnNumber.ordinal() - 1 >= 0) {
          player.getFleetMap().setCell(Row.values()[row],
              Column.values()[columnNumber.ordinal() - 1],
              Cell.createGapWasterCell());
        }
        if (columnNumber.ordinal() + 1 < COLUMN_OF_MAP) {
          player.getFleetMap().setCell(Row.values()[row],
              Column.values()[columnNumber.ordinal() + 1],
              Cell.createGapWasterCell());
        }
      }
      if (rowNumber.ordinal() - 1 >= 0) {
        player.getFleetMap().setCell(Row.values()[rowNumber.ordinal() - 1], columnNumber,
            Cell.createGapWasterCell());
      }
      if (rowNumber.ordinal() + size < ROW_OF_MAP) {
        player.getFleetMap().setCell(Row.values()[rowNumber.ordinal() + size], columnNumber,
            Cell.createGapWasterCell());
      }
    }
  }

  /**
   * Place the ship vertically.
   *
   * @param rowNumber    the row value which we want to place
   * @param columnNumber the column value which we want to place
   * @param size         the size of the ship
   * @param indexOfShip  the index of the ship type
   * @param player       the player who wants to place ship
   */
  public void placeRow(int rowNumber, int columnNumber,
                       int size, int indexOfShip, Player player) {
    int row;
    for (row = rowNumber; row < rowNumber + size; row++) {
      if (indexOfShip == 0) {
        Ship battleShip = Ship.createBattleShip();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[columnNumber],
            Cell.createSpecificShipCell(battleShip));
      }

      if (indexOfShip == 1) {
        Ship cruiser = Ship.createCruiser();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[columnNumber],
            Cell.createSpecificShipCell(cruiser));
      }
      if (indexOfShip == 2) {
        Ship submarine = Ship.createSubmarine();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[columnNumber],
            Cell.createSpecificShipCell(submarine));
      }
      if (indexOfShip == 3) {
        Ship destroyer = Ship.createDestroyer();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[columnNumber],
            Cell.createSpecificShipCell(destroyer));
      }
    }
  }

  /**
   * Place the ship horizontally.
   *
   * @param row         the row value which we want to place
   * @param col         the column value which we want to place
   * @param size        the size of the ship
   * @param indexOfShip the index of the ship type
   * @param player      the player who wants to place ship
   */
  public void placeColumn(int row, int col, int size, int indexOfShip, Player player) {
    int column;
    for (column = col; column < col + size; column++) {
      if (indexOfShip == 3) {
        Ship destroyer = Ship.createDestroyer();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[column],
            Cell.createSpecificShipCell(destroyer));
      }
      if (indexOfShip == 2) {
        Ship submarine = Ship.createSubmarine();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[column],
            Cell.createSpecificShipCell(submarine));
      }
      if (indexOfShip == 1) {
        Ship cruiser = Ship.createCruiser();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[column],
            Cell.createSpecificShipCell(cruiser));
      }
      if (indexOfShip == 0) {
        Ship battleShip = Ship.createBattleShip();
        player.getFleetMap().setCell(Row.values()[row], Column.values()[column],
            Cell.createSpecificShipCell(battleShip));
      }
    }
  }

}
