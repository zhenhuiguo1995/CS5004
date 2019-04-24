package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
  private AbstractTeam homeTeam;
  private AbstractTeam awayTeam;
  private Calendar date = Calendar.getInstance();
  private int homeTeamScore;
  private int awayTeamScore;
  private Game game;
  private AbstractLeague abstractLeague;

  @Before
  public void setUp() throws Exception {
    this.abstractLeague = new BaseballLeague("National Baseball League",
        2, 5, 8, null);
    this.homeTeam = new BaseballTeam("Huston Rockets", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.awayTeam = new BaseballTeam("Lakers", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.date.set(2018, 3, 17);
    this.homeTeamScore = 5;
    this.awayTeamScore = 3;
    this.game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
  }



  @Test(expected = IllegalArgumentException.class)
  public void invalidBaseballGame() throws IllegalArgumentException {
    this.awayTeamScore = this.homeTeamScore;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidTeamType() throws Exception {
    this.awayTeam = new AmericanFootballTeam(
        "Lakers", new AmericanFootballLeague("Go huskies", 1,
        4, 16, null), 0, 8,
        0, null, new Record());
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
  }

  @Test
  public void constructNewBaseballGame() {
    this.homeTeamScore = 0;
    this.awayTeamScore = 0;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
  }

  @Test
  public void constructSoccerGame() {
    this.homeTeam = new SoccerTeam("Huston Rockets", this.abstractLeague, 0,
        8, 4, null, new Record());
    this.awayTeam = new SoccerTeam("Lakers", this.abstractLeague, 0,
        8, 0, null, new Record());
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
  }

  @Test
  public void getOutcome() throws FutureGameException {
    LocalDateTime.now();
    assertEquals(Result.NOT_A_TIE, this.game.getOutcome());
  }

  @Test(expected = FutureGameException.class)
  public void futureGame() throws FutureGameException {
    this.homeTeamScore = 0;
    this.awayTeamScore = 0;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    game.getOutcome();
  }

  @Test(expected = FutureGameException.class)
  public void offSeasonFirst() throws FutureGameException {
    this.abstractLeague = new BaseballLeague("National Baseball League",
        4, 5, 8, null);
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    this.homeTeam = new BaseballTeam("Huston Rockets", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.awayTeam = new BaseballTeam("Lakers", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    game.getOutcome();
  }


  @Test(expected = FutureGameException.class)
  public void offSeasonSecond() throws FutureGameException {
    this.abstractLeague = new BaseballLeague("National Baseball League",
        1, 1, 8, null);
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    this.homeTeam = new BaseballTeam("Huston Rockets", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.awayTeam = new BaseballTeam("Lakers", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    game.getOutcome();
  }


  @Test
  public void homeTeamWin() throws FutureGameException {
    this.awayTeamScore = 0;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    assertSame(Result.NOT_A_TIE, this.game.getOutcome());
  }

  @Test
  public void awayTeamWin() throws FutureGameException {
    this.homeTeamScore = 0;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    assertSame(Result.NOT_A_TIE, this.game.getOutcome());
  }

  @Test
  public void tieGame() throws FutureGameException {
    this.homeTeam = new SoccerTeam("Huston Rockets", this.abstractLeague, 0,
        8, 4, null, new Record());
    this.awayTeam = new SoccerTeam("Lakers", this.abstractLeague, 0,
        8, 0, null, new Record());
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    this.homeTeamScore = this.awayTeamScore;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    assertSame(Result.TIE, this.game.getOutcome());
  }


  @Test
  public void getWinningTeam() throws Exception {
    assertSame(this.homeTeam, this.game.getWinningTeam());
  }

  @Test(expected = TiedGameException.class)
  public void tiedGameException() throws TiedGameException, FutureGameException {
    this.homeTeam = new SoccerTeam("Huston Rockets", this.abstractLeague, 0,
        8, 4, null, new Record());
    this.awayTeam = new SoccerTeam("Lakers", this.abstractLeague, 0,
        8, 0, null, new Record());
    this.homeTeamScore = this.awayTeamScore;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    game.getWinningTeam();
  }

  @Test
  public void awayTeamWins() throws Exception {
    this.homeTeamScore = this.awayTeamScore - 1;
    game = new Game(homeTeam, awayTeam, date, homeTeamScore, awayTeamScore);
    assertSame(this.awayTeam, this.game.getWinningTeam());
  }

  @Test
  public void getDate() throws Exception {
    assertSame(this.date, this.game.getDate());
  }

  @Test
  public void getHomeTeamScore() throws Exception {
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
  }

  @Test
  public void getAwayTeamScore() throws Exception {
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void getHomeTeam() throws Exception {
    assertSame(this.homeTeam, this.game.getHomeTeam());
  }

  @Test
  public void getAwayTeam() throws Exception {
    assertSame(this.awayTeam, this.game.getAwayTeam());
  }

}