/**
 * Represents the details of an address, incluidng street number,
 * street name, city name, state acronym, a zip code, country name
 *
 * @author Zhenhui
 */
public class Address {
    private int streetNumber;
    private String streetName;
    private String cityName;
    private String stateAcronym;
    private int zipCode;
    private String countryName;

    /**
     * Creates an address, givem the street number, street name, city name
     * state acronym, zip code and country name.
     * @param streetNumber, the street number of the address.
     * @param streetName, the street name of the address.
     * @param cityName, the city name of the address.
     * @param stateAcronym, the state acronym of the state where the city is in.
     * @param zipCode, the zip code of the address.
     * @param countryName, the country name of the address.
     */
    public Address(int streetNumber, String streetName, String cityName,
                   String stateAcronym, int zipCode, String countryName) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateAcronym = stateAcronym;
        this.zipCode = zipCode;
        this.countryName = countryName;
    }

    /**
     * Returns the street number.
     * @return the street number.
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Returns the street name.
     * @return the street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Returns the city name.
     * @return the city name.
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Returns the state acronym.
     * @return the state acronym.
     */
    public String getStateAcronym() {
        return stateAcronym;
    }

    /**
     * Returns the zip code.
     * @return the zip code.
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Returns the country name.
     * @return the country name.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the street number.
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Sets the street name.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Sets the city name.
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Sets the state acronym.
     */
    public void setStateAcronym(String stateAcronym) {
        this.stateAcronym = stateAcronym;
    }

    /**
     * Sets the zip code.
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Sets the country name.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
