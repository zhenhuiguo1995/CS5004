import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicyclistTest {
    private String name;
    private String team;
    private Time startTime;
    private Time endTime;
    private Bicyclist bicyclist;

    @Before
    public void setUp() throws Exception {
        this.name = "Alexander";
        this.team = "Go Huskies";
        this.startTime = new Time(15, 28, 9);
        this.endTime = new Time(8, 17, 2);
        this.bicyclist = new Bicyclist(name, team, startTime, endTime);
    }

    @Test
    public void getBicyclistName() throws Exception {
        assertEquals(this.name, bicyclist.getBicyclistName());
    }

    @Test
    public void setBicyclistName() throws Exception {
        String anotherName = "Robert";
        this.bicyclist.setBicyclistName(anotherName);
        assertEquals(anotherName, this.bicyclist.getBicyclistName());
    }

    @Test
    public void getTeam() throws Exception {
        assertEquals(this.team, bicyclist.getTeam());
    }

    @Test
    public void setTeam() throws Exception {
        String anotherTeam = "Cheerup Northeastern";
        this.bicyclist.setTeam(anotherTeam);
        assertEquals(anotherTeam, this.bicyclist.getTeam());
    }

    @Test
    public void getStartTime() throws Exception {
        assertEquals(this.startTime, bicyclist.getStartTime());
    }

    @Test
    public void setStartTime() throws Exception {
        Time anotherTime = new Time(11, 34, 29);
        this.bicyclist.setStartTime(anotherTime);
        assertEquals(anotherTime, this.bicyclist.getStartTime());

    }

    @Test
    public void getEndTime() throws Exception {
        assertEquals(this.endTime, bicyclist.getEndTime());
    }

    @Test
    public void setEndTime() throws Exception {
        Time anotherTime = new Time(15, 9, 56);
        this.bicyclist.setEndTime(anotherTime);
        assertEquals(anotherTime, this.bicyclist.getEndTime());
    }

    @Test
    public void getDuration() throws Exception {
        this.bicyclist.setStartTime(new Time(15, 28, 9));
        this.bicyclist.setEndTime(new Time(8, 17, 2));
        Time duration = this.bicyclist.getDuration();
        int seconds = 2 - 9 + 60;
        int minutes = 17 - 1 - 28 + 60;
        int hours = 8 - 1 - 15 + 24;
        assertEquals(seconds, duration.getSecond());
        assertEquals(minutes, duration.getMinute());
        assertEquals(hours, duration.getHour());
    }

}