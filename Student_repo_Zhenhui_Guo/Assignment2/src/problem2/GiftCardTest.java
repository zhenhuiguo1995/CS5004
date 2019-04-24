package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiftCardTest {
  private int cardNumber;
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private Owner owner;
  private int dollarAmount;
  private int centAmount;
  private Balance balance;
  private GiftCard giftCard;


  @Before
  public void setUp() throws Exception {
    this.cardNumber = 123456789;
    this.firstName = "Nancy";
    this.lastName = "Pearson";
    this.address = "535 Pontius Ave.";
    this.email = "random_generator@cs.com";
    this.owner = new Owner(this.firstName, this.lastName, this.address, this.email);
    this.dollarAmount = 26;
    this.centAmount = 38;
    this.balance = new Balance(this.dollarAmount, this.centAmount);
    this.giftCard = new GiftCard(cardNumber, owner, balance);
  }

  @Test
  public void depositGift() throws Exception {
    int previousDollarAmount = this.giftCard.getBalance().getDollarAmount();
    int previousCentAmount = this.giftCard.getBalance().getCentAmount();
    int dollarAmount = 100;
    int centAmount = 20;
    Deposit newGift = new Deposit(new Balance(dollarAmount, centAmount), "Nancy",
        "Pearson", 123456789);
    this.giftCard = this.giftCard.depositGift(newGift);
    assertEquals(previousDollarAmount + dollarAmount, this.giftCard.getBalance().getDollarAmount());
    assertEquals(previousCentAmount + centAmount, this.giftCard.getBalance().getCentAmount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void firstNameNotMatch() throws Exception {
    Deposit newGift = new Deposit(new Balance(100, 20),
        "Catherine", "Pearson", 123456789);
    this.giftCard.depositGift(newGift);
  }

  @Test(expected = IllegalArgumentException.class)
  public void lastNameNotMatch() throws Exception {
    Deposit newGift = new Deposit(new Balance(100, 20),
        "Nancy", "Goblins", 123456789);
    this.giftCard.depositGift(newGift);
  }

  @Test(expected = IllegalArgumentException.class)
  public void cardNumberNotMatch() throws Exception {
    Deposit newGift = new Deposit(new Balance(100, 20),
        "Nancy", "Pearson", 128732942);
    this.giftCard.depositGift(newGift);
  }

  @Test
  public void getCardNumber() throws Exception {
    assertEquals(this.cardNumber, giftCard.getCardNumber());
  }

  @Test
  public void getOwner() throws Exception {
    assertSame(this.owner, this.giftCard.getOwner());
  }

  @Test
  public void getBalance() throws Exception {
    assertSame(this.balance, this.giftCard.getBalance());
  }

}