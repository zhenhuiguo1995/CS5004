package edu.neu.ccs.cs5004.game.model.map;

import edu.neu.ccs.cs5004.game.model.cell.Cell;

/**
 * Represents a map in battle ship mode.
 */
public interface Map {

  /**
   * Returns the array of cells.
   *
   * @return the array of cells
   */
  Cell[][] getCells();

  /**
   * Returns the cell at given row and column.
   *
   * @param row    the given row
   * @param column the given column
   * @return the desired cell
   */
  Cell getCell(Row row, Column column);

  /**
   * Sets a cell at given row and column to desired new cell.
   *
   * @param row     the given row
   * @param column  the given column
   * @param newCell the given cell
   */
  void setCell(Row row, Column column, Cell newCell);


  /**
   * Creates a new fleet map.
   *
   * @return a new fleet map
   */
  static Map createFleetMap() {
    return new FleetMap();
  }

  /**
   * Creates a new battle map.
   *
   * @return a new battle map
   */
  static Map createBattleMap() {
    return new BattleMap();
  }

}
