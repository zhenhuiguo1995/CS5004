package edu.neu.ccs.cs5004;

/**
 * Represents details of a receipt item.
 */
public class ReceiptItem extends Item {

  /**
   * Instantiates a new receipt item.
   *
   * @param product -- product to be added into the receipt.
   * @param quantity -- quantity to be added into the receipt.
   */
  public ReceiptItem(AbstractProduct product, int quantity) {
    super(product, quantity);
  }
}
