package edu.neu.ccs.cs5004.game.model.strategy;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.cell.Cell;
import edu.neu.ccs.cs5004.game.model.cell.ShipCell;
import edu.neu.ccs.cs5004.game.model.cell.WaterCell;
import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;
import edu.neu.ccs.cs5004.game.view.Interaction;


/**
 * Represents a user strategy.
 */
class UserStrategy extends AbstratStrategy {

  @Override
  public AttackResult hitResult(Player player, Player computer) {
    System.out.println("Please select a cell to attack");

    while (true) {
      String rowStr = Interaction.getRowString();
      Row row = Row.values()[Integer.parseInt(rowStr) - 1]; // get the row

      String colStr = Interaction.getColumnString();
      Column col = Column.values()[colStr.charAt(0) - 'A']; // get the column

      Cell enemyCell = computer.getFleetMap().getCell(row, col);

      if (enemyCell instanceof ShipCell) {
        if (enemyCell.isHited() || enemyCell.isSunked()) {
          continue;   // re-enter the location of the cell.
        } else {
          enemyCell.attackCell();
          player.getBattleMap().setCell(row, col, enemyCell);
          return AttackResult.createHit();
        }
      }

      if (enemyCell instanceof WaterCell) {
        if (enemyCell.isHited()) {
          continue;   // re-enter the location of the cell.
        } else {
          enemyCell.attackCell();
          player.getBattleMap().setCell(row, col, enemyCell);
          return AttackResult.createMiss();
        }
      }
    }
  }
}
