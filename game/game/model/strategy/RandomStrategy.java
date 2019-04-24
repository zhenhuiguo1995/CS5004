package edu.neu.ccs.cs5004.game.model.strategy;

import edu.neu.ccs.cs5004.game.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.game.model.cell.Cell;
import edu.neu.ccs.cs5004.game.model.map.Column;
import edu.neu.ccs.cs5004.game.model.map.Row;
import edu.neu.ccs.cs5004.game.model.player.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a random strategy.
 */
class RandomStrategy extends AbstratStrategy {
  private static final int ROW_OF_MAP = 10;
  private static final int COLUMN_OF_MAP = 10;

  @Override
  public AttackResult hitResult(Player user, Player opponent) {
    int row = ThreadLocalRandom.current().nextInt(0, ROW_OF_MAP);
    int column = ThreadLocalRandom.current().nextInt(0, COLUMN_OF_MAP);
    Cell fleetCell = opponent.getFleetMap().getCell(Row.values()[row], Column.values()[column]);
    if (!legalHit(fleetCell)) {
      hitResult(user, opponent);
    }
    fleetCell.attackCell();
    AttackResult result = fleetCell.attackResult();
    user.getBattleMap().setCell(Row.values()[row], Column.values()[column], fleetCell);
    return result;
  }

  /**
   * Returns true if the the cell is not hit yet, false otherwise.
   *
   * @return true or false
   */
  private Boolean legalHit(Cell cell) {
    if (cell.isHited()) {
      return false;
    }
    return true;
  }
}
