package problem2;

/**
 * Represents detailed information of a gift card, including
 * the card number, owner, and card balance
 */
public class GiftCard {
  private int cardNumber;
  private Owner owner;
  private Balance balance;
  private int minCardNumber = 100000000;
  private int maxCardNumber = 999999999;

  /**
   * Creates a gift card.
   *
   * @param cardNumber the number of the card.
   * @param owner the owner of the card.
   * @param balance the balance of the card.
   */
  public GiftCard(int cardNumber, Owner owner, Balance balance) throws Exception{
    if (cardNumber < this.minCardNumber || cardNumber > this.maxCardNumber) {
      throw new IllegalArgumentException("Card number should be a 9-digit integer");
    } else {
      this.cardNumber = cardNumber;
    }
    this.owner = owner;
    this.balance = balance;
  }

  /**
   * Make a deposit to a gift card.
   * @param newGift the balance to be deposited.
   * @return a new gift card object.
   * @throws Exception illegal argument exception.
   */
  public GiftCard depositGift(Deposit newGift) throws Exception {
    if (newGift.getFirstName().equals(this.getOwner().getFirstName()) &&
        newGift.getLastName().equals(this.getOwner().getLastName()) &&
        newGift.getCardNumber() == this.getCardNumber()) {
      int centAmount = this.getBalance().getCentAmount() +
          newGift.getDepositAmount().getCentAmount();
      int dollarAmount = this.getBalance().getDollarAmount() +
          newGift.getDepositAmount().getDollarAmount();
      return new GiftCard(this.cardNumber, this.owner, new Balance(dollarAmount, centAmount));
    } else {
      throw new IllegalArgumentException("Cannot match gift card information");
    }
  }

  /**
   * @return the number of the gift card.
   */
  public int getCardNumber() {
    return cardNumber;
  }

  /**
   * @return the owner of the gift card.
   */
  public Owner getOwner() {
    return owner;
  }

  /**
   * @return the balance of the gift card.
   */
  public Balance getBalance() {
    return balance;
  }
}
