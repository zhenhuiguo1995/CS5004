package edu.neu.ccs.cs5004.game.view.observer;

import edu.neu.ccs.cs5004.game.model.cell.Cell;
import edu.neu.ccs.cs5004.game.model.cell.ShipCell;
import edu.neu.ccs.cs5004.game.model.map.Map;

/**
 * Printer for the computer's fleet map.
 */
public class ComputerFleetMapPrinter implements MapObserver {
  public static final int INDEX = 10;

  @Override
  public void update(Map newMap) {
    System.out.println("Computer's fleet map: ");
    Cell[][] cells = newMap.getCells();
    System.out.println("    A  B  C  D  E  F  G  H  I  J");
    for (int i = 0; i < INDEX; i++) {
      String str = "";
      str = str + (i + 1);
      if (i != INDEX - 1) {
        str = str + " ";
      }
      for (int j = 0; j < INDEX; j++) {
        if (cells[i][j] instanceof ShipCell) {
          str = str + "  " + "o";
        } else if (cells[i][j].getClass() == Cell.createGapWasterCell().getClass()) {
          str = str + "  " + "-";
        } else {
          str = str + "   ";
        }
      }
      System.out.println(str);
    }
    System.out.println();
  }
}
