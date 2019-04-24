package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
  private MONTH month;
  private Integer year;
  private Date date;

  @Before
  public void setUp() throws Exception {
    this.month = MONTH.August;
    this.year = 2017;
    this.date = new Date(this.month, this.year);
  }

  @Test
  public void getMonth() throws Exception {
    assertEquals(this.month, this.date.getMonth());
  }

  @Test
  public void getYear() throws Exception {
    assertEquals(this.year, this.date.getYear());
  }

  @Test(expected = IllegalArgumentException.class)
  public void yearTooSmall() throws Exception {
    this.year = 201;
    this.date = new Date(this.month, this.year);
  }

  @Test(expected = IllegalArgumentException.class)
  public void yearTooLarge() throws Exception {
    this.year = 20121;
    this.date = new Date(this.month, this.year);
  }


}