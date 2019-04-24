package edu.neu.ccs.cs5004.game.model.map;

import edu.neu.ccs.cs5004.game.model.cell.Cell;

import java.util.Arrays;


abstract class AbstractMap implements Map {
  private Cell[][] cell;
  public static final Integer COLUMN = 10;
  public static final Integer ROW = 10;

  /**
   * Initialized the map with water cells.
   */
  public AbstractMap() {
    cell = new Cell[ROW][COLUMN];
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        cell[row.ordinal()][column.ordinal()] = Cell.createOpenSeaWaterCell();
      }
    }
  }

  /**
   * Returns the array of cells.
   *
   * @return the array of cells
   */
  public Cell[][] getCells() {
    return this.cell;
  }

  /**
   * Set the value of the cell with given cell by providing the position.
   *
   * @param row     the row value of the map
   * @param column  the column value of the map
   * @param newCell the cell which we want to assign to
   */
  public void setCell(Row row, Column column, Cell newCell) {
    this.cell[row.ordinal()][column.ordinal()] = newCell;
  }

  /**
   * Return the cell which occupies the provided position.
   *
   * @param row    the row value of the map
   * @param column the column value of the map
   * @return the cell which occupies the provided position
   */
  public Cell getCell(Row row, Column column) {
    return cell[row.ordinal()][column.ordinal()];
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        if (!this.cell[row.ordinal()][column.ordinal()]
            .equals(((Map) obj).getCell(row, column))) {
          return false;
        }
      }
    }
    return true;

  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(cell);
  }

}
