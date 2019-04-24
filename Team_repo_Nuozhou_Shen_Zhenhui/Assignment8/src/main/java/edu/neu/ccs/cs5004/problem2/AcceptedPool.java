package edu.neu.ccs.cs5004.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents details of a pool of existing accepted drivers.
 */
public class AcceptedPool {

  private Map<Driver, List<Vehicle>> pool;

  /**
   * Instantiates a new AcceptedPool.
   *
   * @param map -- the map of driver and list of vehicle
   */
  public AcceptedPool(Map<Driver, List<Vehicle>> map) {
    this.pool = map;
  }

  /**
   * Instantiates a new AcceptedPool.
   */
  public AcceptedPool() {
    this.pool = new HashMap<>();
  }

  /**
   * Get the pool.
   *
   * @return the pool
   */
  public Map<Driver, List<Vehicle>> getPool() {
    return pool;
  }


  /**
   * Add driver and vehicle into the list.
   *
   * @param driver -- driver to be added.
   * @param vehicle -- vehicle to be added.
   * @return boolean -- return true if added the driver and vehicle, false otherwise
   */
  public boolean addDriver(Driver driver, Vehicle vehicle) {
    if (!pool.containsKey(driver)) {
      List<Vehicle> list = new ArrayList<>();
      list.add(vehicle);
      pool.put(driver, list);
      return true;
    } else {
      try {
        checkDuplicateInPool(pool.get(driver), vehicle);
        pool.get(driver).add(vehicle);
        return true;
      } catch (DuplicateInPoolException e) {
        return false;
      }
    }

  }

  /**
   * Check the duplicate in pool.
   *
   * @param vehicleInPoor -- vehicle in pool
   * @param vehicleToAdd -- vehicle to be added
   * @throws DuplicateInPoolException -- if the vehicle has been added.
   */
  public void checkDuplicateInPool(List<Vehicle> vehicleInPoor, Vehicle vehicleToAdd)
      throws DuplicateInPoolException {
    for (Vehicle vehicle : vehicleInPoor) {
      if (vehicle.equals(vehicleToAdd)) {
        throw new DuplicateInPoolException("The drive and vehicle have been added!");
      }
    }
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "AcceptedPool{"
        + "pool=" + pool
        + '}';
  }

  /**
   * Check if equals.
   *
   * @param object -- to be checked object.
   * @return true if two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AcceptedPool that = (AcceptedPool) object;
    return Objects.equals(pool, that.pool);
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(pool);
  }
}