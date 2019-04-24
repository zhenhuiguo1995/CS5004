package edu.neu.ccs.cs5004.game.model.player;


import edu.neu.ccs.cs5004.game.model.map.Map;
import edu.neu.ccs.cs5004.game.model.place.Place;

class User extends AbstractPlayer {
  public User(Map fleetMap, Map battleMap, int[] number) {
    super(fleetMap, battleMap, number);
  }


  public void placeShip(Place placement) {
    placement.actualPlace(this);
  }
}
