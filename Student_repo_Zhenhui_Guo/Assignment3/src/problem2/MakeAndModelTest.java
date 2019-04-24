package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MakeAndModelTest {
  private String make;
  private String model;
  private MakeAndModel makeAndModel;

  @Before
  public void setUp() throws Exception {
    this.make = "Audi";
    this.model = "A4 Sedan";
    this.makeAndModel = new MakeAndModel(this.make, this.model);
  }

  @Test
  public void getMake() throws Exception {
    assertEquals(this.make, this.makeAndModel.getMake());
  }

  @Test
  public void getModel() throws Exception {
    assertEquals(this.model, this.makeAndModel.getModel());
  }

}