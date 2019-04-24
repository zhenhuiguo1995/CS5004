package edu.neu.ccs.cs5004.game.view.observer;

import edu.neu.ccs.cs5004.game.model.map.Map;

/**
 * Defines an interface for map observers.
 */
public interface MapObserver {
  void update(Map newMap);
}
