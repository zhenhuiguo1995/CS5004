package edu.neu.ccs.cs5004.game.model.strategy;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Represents a smart strategy in the game.
 */
class SmartStrategy extends AbstratStrategy {
  private static final int ROW_OF_MAP = 10;
  private static final int COLUMN_OF_MAP = 10;

  @Override
  public AttackResult hitResult(Player user, Player opponent) {
    int row = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
    int column = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
    while (opponent.getFleetMap().getCell(Row.values()[row],
        Column.values()[column]).isHited()) {
      row = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
      column = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
    }
    for (; row < ROW_OF_MAP; row++) {
      for (; column < COLUMN_OF_MAP; column++) {
        if (user.getBattleMap().getCell(Row.values()[row],
            Column.values()[column]).attackResult().getClass()
            == AttackResult.createSunk().getClass() && legalLeft(column, true)
            && !opponent.getFleetMap().getCell(Row.values()[row],
            Column.values()[column - 2]).isHited()) {
          opponent.getFleetMap().getCell(Row.values()[row],
              Column.values()[column - 2]).attackCell();
          user.getBattleMap().setCell(Row.values()[row],
              Column.values()[column - 2],
              opponent.getFleetMap().getCell(Row.values()[row],
                  Column.values()[column - 2]));
          return user.getBattleMap().getCell(Row.values()[row],
              Column.values()[column - 2]).attackResult();
        }
        if (user.getBattleMap().getCell(Row.values()[row],
            Column.values()[column]).attackResult().getClass()
            == AttackResult.createHit().getClass() && legalLeft(column, false)
            && !opponent.getFleetMap().getCell(Row.values()[row],
            Column.values()[column - 1]).isHited()) {
          opponent.getFleetMap().getCell(Row.values()[row],
              Column.values()[column - 1]).attackCell();
          user.getBattleMap().setCell(Row.values()[row],
              Column.values()[column - 1],
              opponent.getFleetMap().getCell(Row.values()[row],
                  Column.values()[column - 1]));
          return user.getBattleMap().getCell(Row.values()[row],
              Column.values()[column - 1]).attackResult();
        }
      }
    }
    int rowRandom = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
    int columnRandom = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
    while (opponent.getFleetMap().getCell(Row.values()[rowRandom],
        Column.values()[columnRandom]).isHited()) {
      rowRandom = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
      columnRandom = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
    }
    opponent.getFleetMap().getCell(Row.values()[rowRandom],
        Column.values()[columnRandom]).attackCell();
    user.getBattleMap().setCell(Row.values()[rowRandom],
        Column.values()[columnRandom],
        opponent.getFleetMap().getCell(Row.values()[rowRandom],
            Column.values()[columnRandom]));
    return user.getBattleMap().getCell(Row.values()[rowRandom],
        Column.values()[columnRandom]).attackResult();
  }

  /**
   * Check if the left block is legal.
   *
   * @param column the current column value
   * @param sunk   if the cell is sunk
   * @return true if the left block is in the range(0-9)
   */
  private Boolean legalLeft(int column, Boolean sunk) {
    if (sunk) {
      return (column - 2 >= 0);
    } else {
      return (column - 1 >= 0);
    }
  }

}