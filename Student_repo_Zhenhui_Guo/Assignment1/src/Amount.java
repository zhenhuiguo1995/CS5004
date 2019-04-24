/**
 * Representing information about an amount.
 */
public class Amount {
    private int dollarAmount;
    private int centAmount;

    /**
     * Creates an amount given the amount in dollars and cents.
     *
     * @param dollarAmount, the dollar amount.
     * @param centAmount, the cent amount.
     */
    public Amount(int dollarAmount, int centAmount) {
        if (dollarAmount < 0) {
            System.out.println("Invalid amount in dollar " + dollarAmount);
            return;
        } else {
            this.dollarAmount = dollarAmount;
        }
        if (centAmount < 0 || centAmount >= 100) {
            System.out.println("Invalid amount in cent " + centAmount);
            return;
        } else {
            this.centAmount = centAmount;
        }
    }

    /**
     * Returns the dollar amount.
     * @return the dollar amount.
     */
    public int getDollarAmount() {
        return dollarAmount;
    }

    /**
     * Sets the dollar amount.
     */
    public void setDollarAmount(int dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    /**
     * Return the cent amount.
     * @return the cent amount.
     */
    public int getCentAmount() {
        return centAmount;
    }

    /**
     * Sets the cent amount.
     */
    public void setCentAmount(int centAmount) {
        this.centAmount = centAmount;
    }
}

