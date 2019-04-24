package problem2;

/**
 * Representing detailed information of a deposit, including the deposit amount,
 * the first and last name of the owner and the card number.
 */
public class Deposit {
  private Balance depositAmount;
  private String firstName;
  private String lastName;
  private int cardNumber;
  private int minCardNumber = 100000000;
  private int maxCardNumber = 999999999;
  private int minDollarAmount = 1;
  private int maxDepostAmount = 200;
  private double centRatio = 0.01;

  /**
   * Creates a deposit object.
   *
   * @param depositAmount the amount to be deposited, in the range of 0 ~ 200 dollars.
   * @param firstName the first name of the owner.
   * @param lastName the last name of the owner.
   * @param cardNumber the gift card number.
   */
  public Deposit(Balance depositAmount, String firstName, String lastName, int cardNumber)
    throws Exception{
    if (cardNumber < this.minCardNumber || cardNumber > this.maxCardNumber) {
      throw new IllegalArgumentException("Card number must be a 9-digit number");
    } else if (depositAmount.getDollarAmount() < this.minDollarAmount ||
        depositAmount.getDollarAmount() + depositAmount.getCentAmount() * this.centRatio >
            this.maxDepostAmount) {
      throw new IllegalArgumentException("Deposit amount should be within 1~200 dollars");
    } else {
      this.depositAmount = depositAmount;
      this.firstName = firstName;
      this.lastName = lastName;
      this.cardNumber = cardNumber;
    }
  }

  /**
   * @return the deposit amount.
   */
  public Balance getDepositAmount() {
    return depositAmount;
  }

  /**
   * @return the first name of the owner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the last name of the owner.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return the number of the gift card.
   */
  public int getCardNumber() {
    return cardNumber;
  }
}
