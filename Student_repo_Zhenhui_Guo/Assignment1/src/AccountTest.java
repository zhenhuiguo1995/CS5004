import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    private AccountHolder accountHolder;
    private Amount amount;
    private Account account;

    @Before
    public void setUp() throws Exception {
        accountHolder = new AccountHolder("Arya", "Stark");
        amount = new Amount(1982, 67);
        account = new Account(accountHolder, amount);
    }

    @Test
    public void deposit() throws Exception {
        Amount depositAmount = new Amount(276, 5);
        int expectedDollarAmount = this.amount.getDollarAmount() + depositAmount.getDollarAmount();
        int expectedCentAmount = this.amount.getCentAmount() + depositAmount.getCentAmount();
        Account anotherAccount = account.deposit(depositAmount);
        assertEquals(expectedDollarAmount, anotherAccount.getAmount().getDollarAmount());
        assertEquals(expectedCentAmount, anotherAccount.getAmount().getCentAmount());
    }

    @Test
    public void withdrawal() throws Exception {
        Amount withdrawalAmount = new Amount(1800, 80);
        int expectedDollarAmount, expectedCentAmount;
        if (withdrawalAmount.getCentAmount() > account.getAmount().getCentAmount()) {
            expectedCentAmount = this.amount.getCentAmount() + 100 - withdrawalAmount.getCentAmount();
            expectedDollarAmount = this.amount.getDollarAmount() - 1 - withdrawalAmount.getDollarAmount();
        } else {
            expectedDollarAmount = this.amount.getDollarAmount() - withdrawalAmount.getDollarAmount();
            expectedCentAmount = this.amount.getCentAmount() - withdrawalAmount.getCentAmount();
        }
        Account anotherAccount = account.withdrawal(withdrawalAmount);
        assertEquals(expectedDollarAmount, anotherAccount.getAmount().getDollarAmount());
        assertEquals(expectedCentAmount, anotherAccount.getAmount().getCentAmount());
    }

    @Test
    public void getHolder() throws Exception {
        assertEquals(this.accountHolder, account.getHolder());
    }

    @Test
    public void setHolder() throws Exception {
        AccountHolder anotherHolder = new AccountHolder("Sansa", "Stark");
        account.setHolder(anotherHolder);
        assertEquals(anotherHolder.getFirstName(), account.getHolder().getFirstName());
        assertEquals(anotherHolder.getLastName(), account.getHolder().getLastName());
    }

    @Test
    public void getAmount() throws Exception {
        assertEquals(this.amount, account.getAmount());
    }

    @Test
    public void setAmount() throws Exception {
        Amount amount = new Amount(145, 29);
        account.setAmount(amount);
        assertEquals(amount.getCentAmount(), account.getAmount().getCentAmount());
        assertEquals(amount.getDollarAmount(), account.getAmount().getDollarAmount());
    }

}