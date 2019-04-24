package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LicensePlateTest {
  private State state;
  private String licenseNumber;
  private MONTH month;
  private Integer year;
  private Date expireDate;
  private LicensePlate licensePlate;

  @Before
  public void setUp() throws Exception {
    this.state = State.WA;
    this.licenseNumber = "162-ZOZ";
    this.month = MONTH.August;
    this.year = 2019;
    this.expireDate = new Date(this.month, this.year);
    this.licensePlate = new LicensePlate(this.state, this.licenseNumber, this.expireDate);
  }

  @Test
  public void getState() throws Exception {
    assertEquals(this.state, this.licensePlate.getState());
  }

  @Test
  public void getLicenseNumber() throws Exception {
    assertEquals(this.licenseNumber, this.licensePlate.getLicenseNumber());
  }

  @Test
  public void getExpireDate() throws Exception {
    assertEquals(this.expireDate, this.licensePlate.getExpireDate());
  }

}