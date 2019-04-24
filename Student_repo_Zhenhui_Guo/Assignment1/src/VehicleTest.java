import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    private int VIN;
    private String licensePlate;
    private Owner owner;
    private Vehicle vehicle;

    @Before
    public void setUp() throws Exception {
        this.VIN = 12345;
        this.licensePlate = "WA923";
        this.owner = new Owner("Alfred", "Guo", "2063904145");
        this.vehicle = new Vehicle(VIN, licensePlate, owner);
    }

    @Test
    public void getVIN() throws Exception {
        assertEquals(VIN, vehicle.getVIN());
    }

    @Test
    public void getLicensePlate() throws Exception {
        assertEquals(licensePlate, vehicle.getLicensePlate());
    }

    @Test
    public void getOwner() throws Exception {
        Assert.assertEquals(owner, vehicle.getOwner());
    }

    @Test
    public void setVIN() throws Exception {
        int anotherVIN = 923893742;
        vehicle.setVIN(anotherVIN);
        assertEquals(anotherVIN, vehicle.getVIN());
    }

    @Test
    public void setLicensePlate() throws Exception {
        String anotherLicensePlate = "NY76223";
        vehicle.setLicensePlate(anotherLicensePlate);
        assertEquals(anotherLicensePlate, vehicle.getLicensePlate());
    }

    @Test
    public void setOwner() throws Exception {
        Owner anotherOwner = new Owner("Nacy", "Fray", "2062263212");
        vehicle.setOwner(anotherOwner);
        Assert.assertEquals(anotherOwner, vehicle.getOwner());
    }

}