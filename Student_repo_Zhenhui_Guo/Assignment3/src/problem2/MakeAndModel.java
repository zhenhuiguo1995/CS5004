package problem2;

/**
 * Represents make and model information of a vehicle.
 */
public class MakeAndModel {
  private String make;
  private String model;

  /**
   * Creates a make and model object.
   *
   * @param make the make of the vehicle.
   * @param model the model of the vehi
   */
  public MakeAndModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  /**
   * Gets make.
   *
   * @return the make of the vehicle.
   */
  public String getMake() {
    return make;
  }

  /**
   * Gets model.
   *
   * @return the model of the vehicle.
   */
  public String getModel() {
    return model;
  }
}
