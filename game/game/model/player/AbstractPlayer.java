package edu.neu.ccs.cs5004.game.model.player;

import edu.neu.ccs.cs5004.game.model.map.Map;

import java.util.Arrays;
import java.util.Objects;


abstract class AbstractPlayer implements Player {
  protected int[] number;
  protected Map fleetMap;
  protected Map battleMap;


  public AbstractPlayer(Map fleetMap, Map battleMap, int[] number) {
    this.fleetMap = fleetMap;
    this.battleMap = battleMap;
    this.number = number;
  }

  /* Gets the fleet configuration */
  public int[] getNumber() {
    return this.number;
  }

  /* Sets the fleet configuration as given */
  public void setNumber(int[] number) {
    this.number = number;
  }

  /* Gets the fleet map. */
  public Map getFleetMap() {
    return this.fleetMap;
  }

  /* Gets the battle map */
  public Map getBattleMap() {
    return this.battleMap;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractPlayer that = (AbstractPlayer) obj;
    return Arrays.equals(number, that.number)
        && Objects.equals(fleetMap, that.fleetMap)
        && Objects.equals(battleMap, that.battleMap);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(fleetMap, battleMap);
    result = 31 * result + Arrays.hashCode(number);
    return result;
  }
}
