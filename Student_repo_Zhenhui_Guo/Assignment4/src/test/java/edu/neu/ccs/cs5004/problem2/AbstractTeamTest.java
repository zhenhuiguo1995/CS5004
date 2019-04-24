package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AbstractTeamTest {
  private String name;
  private AbstractLeague abstractLeague;
  private int gamePlayed;
  private int gameRemaining;
  private int points;
  private Game lastGame;
  private Record record;
  private AbstractTeam abstractTeam;
  private Calendar date = Calendar.getInstance();

  @Before
  public void setUp() throws Exception {
    this.name = "Huston Rockets";
    this.gamePlayed = 0;
    this.gameRemaining = 8;
    this.points = 0;
    this.lastGame = null;
    this.record = new Record();
    this.abstractLeague = new BaseballLeague("CBA", 5, 6, 8, null);
    this.abstractTeam = new BaseballTeam(this.name, this.abstractLeague, this.gamePlayed,
        this.gameRemaining, this.points, this.lastGame, this.record);
  }

  @Test
  public void getName() throws Exception {
    assertSame(this.name, this.abstractTeam.getName());
  }

  @Test
  public void getGamePlayed() throws Exception {
    assertEquals(this.gamePlayed, this.abstractTeam.getGamePlayed());
  }

  @Test
  public void getGameRemaining() throws Exception {
    assertEquals(this.gameRemaining, this.abstractTeam.getGameRemaining());
  }

  @Test
  public void getPoints() throws Exception {
    assertEquals(this.points, this.abstractTeam.getPoints());
  }

  @Test(expected = InvalidGameException.class)
  public void invalidLastGame() throws InvalidGameException {
    this.abstractTeam.getLastGame();
  }

  @Test
  public void getLastGame() throws Exception {
    BaseballTeam homeTeam = new BaseballTeam("Lakers", this.abstractLeague,
        this.gamePlayed, this.gameRemaining, this.points, this.lastGame, this.record);
    BaseballTeam awayTeam = new BaseballTeam("Seattle Huskies", this.abstractLeague,
        this.gamePlayed, this.gameRemaining, this.points, this.lastGame, this.record);
    date.set(2, 2, 2018);
    this.lastGame = new Game(homeTeam, awayTeam, date ,3, 2);
    this.abstractTeam = new BaseballTeam(this.name, this.abstractLeague, this.gamePlayed,
        this.gameRemaining, this.points, this.lastGame, this.record);
    assertSame(this.lastGame, this.abstractTeam.getLastGame());
  }


  @Test
  public void getAbstractLeague() throws Exception {
    assertSame(this.abstractLeague, this.abstractTeam.getAbstractLeague());
  }

  @Test
  public void getRecord() throws Exception {
    assertSame(this.record, this.abstractTeam.getRecord());
  }

}