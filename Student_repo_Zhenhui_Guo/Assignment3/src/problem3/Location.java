package problem3;

/**
 * Represents detailed information of a location, including city and country.
 */
public class Location {
  private String city;
  private String country;

  /**
   * Creates a location.
   *
   * @param city the city of the location.
   * @param country the country of the location.
   */
  public Location(String city, String country) {
    this.city = city;
    this.country = country;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }
}
