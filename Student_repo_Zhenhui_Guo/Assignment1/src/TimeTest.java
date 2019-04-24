import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    private int hour;
    private int minute;
    private int second;
    private Time time;
    @Before
    public void setUp() throws Exception {
        this.hour = 19;
        this.minute = 6;
        this.second = 29;
        this.time = new Time(hour, minute, second);
    }

    @Test
    public void getHour() throws Exception {
        assertEquals(this.hour, this.time.getHour());
    }

    @Test
    public void setHour() throws Exception {
        int anotherHour = 8;
        this.time.setHour(anotherHour);
        assertEquals(anotherHour, this.time.getHour());
    }

    @Test
    public void getMinute() throws Exception {
        assertEquals(this.minute, this.time.getMinute());
    }

    @Test
    public void setMinute() throws Exception {
        int anotherMinute = 54;
        this.time.setMinute(anotherMinute);
        assertEquals(anotherMinute, this.time.getMinute());
    }

    @Test
    public void getSecond() throws Exception {
        assertEquals(this.second, this.time.getSecond());
    }

    @Test
    public void setSecond() throws Exception {
        int anotherSecond = 36;
        this.time.setSecond(anotherSecond);
        assertEquals(anotherSecond, this.time.getSecond());
    }

}