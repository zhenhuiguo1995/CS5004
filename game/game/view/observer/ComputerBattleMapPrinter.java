package edu.neu.ccs.cs5004.game.view.observer;


import edu.neu.ccs.cs5004.game.model.cell.Cell;
import edu.neu.ccs.cs5004.game.model.cell.ShipCell;
import edu.neu.ccs.cs5004.game.model.cell.WaterCell;
import edu.neu.ccs.cs5004.game.model.map.Map;

/**
 * Printer for the computer.
 */
public class ComputerBattleMapPrinter implements MapObserver {
  public static final int INDEX = 10;

  @Override
  public void update(Map newMap) {
    Cell[][] cells = newMap.getCells();
    System.out.println("Computer's battle map: ");
    System.out.println("    A  B  C  D  E  F  G  H  I  J");
    for (int i = 0; i < INDEX; i++) {
      String str = "";
      str = str + (i + 1);
      if (i != INDEX - 1) {
        str = str + " ";
      }
      for (int j = 0; j < INDEX; j++) {
        if (cells[i][j] instanceof ShipCell) {
          if (cells[i][j].isHited() || cells[i][j].isSunked()) {
            str = str + "  " + "x";
          }
        } else if (cells[i][j] instanceof WaterCell && cells[i][j].isHited()) {
          str = str + "  " + ".";
        } else {
          str = str + "   ";
        }
      }
      System.out.println(str);
    }
    System.out.println();
  }

}
