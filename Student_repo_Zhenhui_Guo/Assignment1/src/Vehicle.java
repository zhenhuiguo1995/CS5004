/**
 * Class Vehicle, containing information about a vehicle
 */


/**
 * Vehicle is a simple object that has a unique vehicle identification
 * number, and corresponding license plate.
 */

public class Vehicle {
    private int VIN;
    private String licensePlate;
    private Owner owner;

    /**
     * Constructor that create a new vehicle object with the
     * specified VIN and license plate.
     *
     * @param VIN - VIN of the new Vehicle object
     * @param licensePlate - license plate of the new vehicel.
     */
    public Vehicle(int VIN, String licensePlate, Owner owner) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.owner = owner;

    }

    /**
     * Returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public int getVIN() {
        return VIN;
    }

    /**
     * Returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate() {
        return licensePlate;
    }


    /**
     * Returns the owner of the Vehicle.
     * @return the owner of the Vehicle.
     */
    public Owner getOwner() {
        return owner;
    }


    /**
     * Sets the VIN of the Vehicle.
     */
    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    /**
     * Sets the licensePlate of the Vehicle.
     */
    public void setLicensePlate(String lincensePlate) {
        this.licensePlate = lincensePlate;
    }

    /**
     * Sets the owner of the Vehicle
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

