package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DepositTest {
  private int dollarAmount;
  private int centAmount;
  private Balance depositAmount;
  private String firstName;
  private String lastName;
  private int cardNumber;
  private Deposit deposit;

  @Before
  public void setUp() throws Exception {
    this.dollarAmount = 100;
    this.centAmount = 29;
    this.depositAmount = new Balance(this.dollarAmount, this.centAmount);
    this.firstName = "Kevin";
    this.lastName = "Pearson";
    this.cardNumber = 128738272;
    this.deposit = new Deposit(this.depositAmount, "Kevin", "Pearson",
        this.cardNumber);
  }

  @Test
  public void getDepositAmount() throws Exception {
    assertSame(this.depositAmount, this.deposit.getDepositAmount());
  }

  @Test
  public void getFirstName() throws Exception {
    assertEquals(this.firstName, this.deposit.getFirstName());
  }

  @Test
  public void getLastName() throws Exception {
    assertEquals(this.lastName, this.deposit.getLastName());
  }

  @Test
  public void getCardNumber() throws Exception {
    assertEquals(this.cardNumber, this.deposit.getCardNumber());
  }

  @Test(expected = IllegalArgumentException.class)
  public void cardNumberTooSmall() throws Exception {
    this.deposit = new Deposit(this.depositAmount, "Kevin", "Pearson",
        12345678);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cardNumberTooBig() throws Exception {
    this.deposit = new Deposit(this.depositAmount, "Kevin", "Pearson",
        1234567890);
  }

  @Test(expected = IllegalArgumentException.class)
  public void depositAmountTooSmall() throws Exception {
    this.depositAmount = new Balance(0, 20);
    this.deposit = new Deposit(this.depositAmount, "Kevin", "Pearson",
        123456789);
  }

  @Test(expected = IllegalArgumentException.class)
  public void depositAmountTooLarge() throws Exception {
    this.depositAmount = new Balance(200, 1);
    this.deposit = new Deposit(this.depositAmount, "Kevin", "Pearson",
        123456789);
  }

}