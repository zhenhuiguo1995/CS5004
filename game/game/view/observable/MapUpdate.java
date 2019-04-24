package edu.neu.ccs.cs5004.game.view.observable;

import edu.neu.ccs.cs5004.game.model.map.Map;
import edu.neu.ccs.cs5004.game.view.observer.MapObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a map update.
 */
public class MapUpdate implements MapObservable {
  private Map map;
  private List<MapObserver> observers;

  /**
   * Constructs the observable map with provided map and an empty list of observers.
   *
   * @param map the new map
   */
  public MapUpdate(Map map) {
    this.map = map;
    observers = new ArrayList<>();
  }

  /**
   * Getter for map.
   *
   * @return map value
   */
  public Map getMap() {
    return map;
  }


  /**
   * Add observer to a list of observers.
   *
   * @param observer to register to the observable
   */
  public void registerObserver(MapObserver observer) {
    this.observers.add(observer);
  }

  /**
   * Remove observer from a list of observers.
   *
   * @param observer to remove
   */
  public void removeObserver(MapObserver observer) {
    this.observers.remove(observer);
  }

  /**
   * Change the map.
   * @param map the map we want to set
   */
  public void mapChange(Map map) {
    this.map = map;
    notifyObservers();
  }

  /**
   * Notify observer if a model was changed.
   */
  public void notifyObservers() {
    for (MapObserver obs : observers) {
      obs.update(this.map);
    }
  }

  /**
   * Getter for the observers.
   *
   * @return the list of observers
   */
  public List<MapObserver> getObservers() {
    return observers;
  }
}
