package problem2;

/**
 * Represents the balance of a gift card, including dollar amount and cent amount.
 *
 * @author  Alfred
 */
public class Balance {
  private int dollarAmount;
  private int centAmount;
  private int minDollarAmount = 0;
  private int minCentAmount = 0;
  private int maxCentAmount = 99;

  /**
   * Creates a balance of the gift card.
   *
   * @param dollarAmount the amount of dollars in the card.
   * @param centAmount the amount of cents in the card.
   */
  public Balance(int dollarAmount, int centAmount) throws Exception{
    if (dollarAmount < this.minDollarAmount) {
      throw new IllegalArgumentException("Dollar amount cannot be negative");
    } else if (centAmount < this.minCentAmount || centAmount > this.maxCentAmount){
      throw new IllegalArgumentException("Cent amount must be within 0 and 99, inclusive");
    } else {
      this.dollarAmount = dollarAmount;
      this.centAmount = centAmount;
    }
  }

  /**
   * @return the amount of dollars in the card.
   */
  public int getDollarAmount() {
    return dollarAmount;
  }

  /**
   * @return the amount of cents in the card.
   */
  public int getCentAmount() {
    return centAmount;
  }
}
