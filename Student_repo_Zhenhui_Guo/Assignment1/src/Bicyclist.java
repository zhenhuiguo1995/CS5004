/**
 * Represents information about a bicyclist
 */
public class Bicyclist {
    private String bicyclistName;
    private String team;
    private Time startTime;
    private Time endTime;

    /**
     * Creates a bicyclist given the name, team, start time and end time.
     *
     * @param bicyclistName, the name of the bicyclist
     * @param team, the team of the bicyclist.
     * @param startTime, the start time of a ride.
     * @param endTime, the end time of a ride.
     */
    public Bicyclist(String bicyclistName, String team,
                     Time startTime, Time endTime) {
        this.bicyclistName = bicyclistName;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the time of the duration.
     * @return the time of the duration.
     */
    public Time getDuration() {
        int hours, minutes, seconds;
        int startSecond, endSecond;
        startSecond = this.startTime.getHour() * 3600 + this.startTime.getMinute() * 60
                + this.startTime.getSecond();
        endSecond = this.endTime.getHour() * 3600 + this.endTime.getMinute() * 60
                + this.endTime.getSecond();
        int totalSecond = endSecond - startSecond;
        if (totalSecond < 0) {
            totalSecond += 24 * 3600;
        }
        hours = Math.round(totalSecond/3600);
        totalSecond -= hours * 3600;
        minutes = Math.round(totalSecond/60);
        totalSecond -= minutes * 60;
        seconds = totalSecond;

        return new Time(hours, minutes, seconds);
    }
    /**
     * Returns the bicyclist name.
     * @return the bicyclist name
     */
    public String getBicyclistName() {
        return bicyclistName;
    }

    /**
     * Sets the bicyclist name.
     */
    public void setBicyclistName(String bicyclistName) {
        this.bicyclistName = bicyclistName;
    }

    /**
     * Returns the team (name).
     * @return the team name.
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets the team name.
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Returns the start time.
     * @return the start time.
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time.
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the end time.
     * @return the end time.
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time.
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
