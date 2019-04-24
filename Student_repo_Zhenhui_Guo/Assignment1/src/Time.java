import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Representing information about time in a day
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    /**
     * Creates a time given the hour, minute and second.
     *
     * @param hour, the hour of the time.
     * @param minute, the minute of the time.
     * @param second, the second of the time.
     */
    public Time(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            System.out.println("Invalid hour " + hour);
            return;
        } else {
            this.hour = hour;
        }
        if (minute < 0 || minute >= 60) {
            System.out.println("Invalid minute " + minute);
            return;
        } else {
            this.minute = minute;
        }
        if (second < 0 || second >= 60) {
            System.out.println("Invalid second " + second);
            return;
        } else {
            this.second = second;
        }
    }

    /**
     * Returns the hour.
     * @return the hour.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets the hour.
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Returns the minute.
     * @return the minute.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets the minute.
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Returns the second.
     * @return the second.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Sets the second.
     */
    public void setSecond(int second) {
        this.second = second;
    }
}
