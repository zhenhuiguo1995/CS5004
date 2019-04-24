import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    private int dollarAmount;
    private int centAmount;
    private Amount amount;

    @Before
    public void setUp() throws Exception {
        this.dollarAmount = 16;
        this.centAmount = 5;
        this.amount = new Amount(dollarAmount, centAmount);
    }

    @Test
    public void getDollarAmount() throws Exception {
        assertEquals(this.dollarAmount, amount.getDollarAmount());
    }

    @Test
    public void setDollarAmount() throws Exception {
        int anotherDollarAmount = 18723;
        this.amount.setDollarAmount(anotherDollarAmount);
        assertEquals(anotherDollarAmount, this.amount.getDollarAmount());
    }

    @Test
    public void getCentAmount() throws Exception {
        assertEquals(this.centAmount, amount.getCentAmount());
    }

    @Test
    public void setCentAmount() throws Exception {
        int anotherCentAmount = 38;
        this.amount.setCentAmount(anotherCentAmount);
        assertEquals(anotherCentAmount, this.amount.getCentAmount());
    }

}