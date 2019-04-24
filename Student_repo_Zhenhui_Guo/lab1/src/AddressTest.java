import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    private int streetNumber;
    private String streetName;
    private String cityName;
    private String stateAcronym;
    private int zipCode;
    private String countryName;
    private Address address;

    @Before
    public void setUp() throws Exception {
        this.streetNumber = 6710;
        this.streetName = "Terry Ave. N.";
        this.cityName = "Seattle";
        this.stateAcronym = "WA";
        this.zipCode = 98109;
        this.countryName = "United States";
        this.address = new Address(streetNumber, streetName, cityName,
                stateAcronym, zipCode, countryName);
    }

    @Test
    public void getStreetNumber() throws Exception {
        assertEquals(this.streetNumber, address.getStreetNumber());
    }

    @Test
    public void getStreetName() throws Exception {
        assertEquals(this.streetName, address.getStreetName());
    }

    @Test
    public void getCityName() throws Exception {
        assertEquals(this.cityName, address.getCityName());
    }

    @Test
    public void getStateAcronym() throws Exception {
        assertEquals(this.stateAcronym, address.getStateAcronym());
    }

    @Test
    public void getZipCode() throws Exception {
        assertEquals(this.zipCode, address.getZipCode());
    }

    @Test
    public void getCountryName() throws Exception {
        assertEquals(this.countryName, address.getCountryName());
    }

    @Test
    public void setStreetNumber() throws Exception {
        int anotherStreetNumber = 7623;
        this.address.setStreetNumber(anotherStreetNumber);
        assertEquals(anotherStreetNumber, this.address.getStreetNumber());
    }

    @Test
    public void setStreetName() throws Exception {
        String anotherStreetName = "Pontius Ave. N.";
        this.address.setStreetName(anotherStreetName);
        assertEquals(anotherStreetName, this.address.getStreetName());
    }

    @Test
    public void setCityName() throws Exception {
        String anotherCityName = "Los Angelos";
        this.address.setCityName(anotherCityName);
        assertEquals(anotherCityName, this.address.getCityName());
    }

    @Test
    public void setStateAcronym() throws Exception {
        String anotherStateAcronym = "NY";
        this.address.setStateAcronym(anotherStateAcronym);
        assertEquals(anotherStateAcronym, this.address.getStateAcronym());
    }

    @Test
    public void setZipCode() throws Exception {
        int anotherZipCode = 67210;
        this.address.setZipCode(anotherZipCode);
        assertEquals(anotherZipCode, this.address.getZipCode());
    }

    @Test
    public void setCountryName() throws Exception {
        String anotherCountryName = "Canada";
        this.address.setCountryName(anotherCountryName);
        assertEquals(anotherCountryName, this.address.getCountryName());
    }

}