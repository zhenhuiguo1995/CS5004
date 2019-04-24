package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActiveYearsTest {
  private String startYear;
  private String endYear;
  private ActiveYears activeYears;

  @Before
  public void setUp() throws Exception {
    this.startYear = "1998";
    this.endYear = "current";
    this.activeYears = new ActiveYears(this.startYear, this.endYear);
  }

  @Test
  public void getStartYear() throws Exception {
    assertEquals(this.startYear, this.activeYears.getStartYear());
  }

  @Test
  public void getEndYear() throws Exception {
    assertEquals(this.endYear, this.activeYears.getEndYear());
  }

  @Test(expected = IllegalArgumentException.class)
  public void startYearNotFourDigits() throws Exception {
    this.startYear = "998";
    this.activeYears = new ActiveYears(this.startYear, this.endYear);
  }

  @Test(expected = IllegalArgumentException.class)
  public void endYearNotFourDigits() throws Exception {
    this.endYear = "10901";
    this.activeYears = new ActiveYears(this.startYear, this.endYear);
  }

  @Test(expected = IllegalArgumentException.class)
  public void endYearIllegal() throws Exception {
    this.endYear = "present";
    this.activeYears = new ActiveYears(this.startYear, this.endYear);
  }

  @Test
  public void getString() {
    assertEquals("1998-current", this.activeYears.getString());
  }
}