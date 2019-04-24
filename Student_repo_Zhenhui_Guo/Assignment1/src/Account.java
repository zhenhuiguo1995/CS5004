/**
 * Represents information about an account.
 */
public class Account {
    private AccountHolder holder;
    private Amount amount;

    /**
     * Creates a new account given the account holder and amount.
     *
     * @param holder, the account holder.
     * @param amount, the amount of money in the account.
     */
    public Account(AccountHolder holder, Amount amount) {
        this.holder = holder;
        this.amount = amount;
    }

    /**
     * @param depositAmount, the amount to be deposited.
     * @return a new amount
     */
    public Account deposit(Amount depositAmount) {
        int dollar = this.amount.getDollarAmount() + depositAmount.getDollarAmount();
        int cent = this.amount.getCentAmount() + depositAmount.getCentAmount();
        return new Account(this.holder, new Amount(dollar, cent));
    }

    /**
     * @param withdrawalAmount, the amount to withdrawal from the account.
     * @return a new amount
     */
    public Account withdrawal(Amount withdrawalAmount) {
        int dollar, cent;
        if (this.amount.getCentAmount() - withdrawalAmount.getCentAmount() < 0) {
            cent = 100 + this.amount.getCentAmount() - withdrawalAmount.getCentAmount();
            dollar = this.amount.getDollarAmount() - 1 - withdrawalAmount.getDollarAmount();
        } else {
            cent = this.amount.getCentAmount() - withdrawalAmount.getCentAmount();
            dollar = this.amount.getDollarAmount() - withdrawalAmount.getDollarAmount();
        }
        return new Account(this.holder, new Amount(dollar, cent));
    }

    /**
     * Returns the holder.
     */
    public AccountHolder getHolder() {
        return holder;
    }

    /**
     * Sets the holder.
     */
    public void setHolder(AccountHolder holder) {
        this.holder = holder;
    }

    /**
     * Returns the amount.
     * @return the amount.
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     */
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
