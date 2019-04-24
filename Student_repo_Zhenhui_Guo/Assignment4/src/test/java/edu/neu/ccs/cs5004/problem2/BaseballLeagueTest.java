package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class BaseballLeagueTest {
  private String leagueName;
  private int startMonths;
  private int endMonths;
  private int numberOfGames;
  private Game nextGame;
  private BaseballLeague baseballLeague;
  private BaseballTeam homeTeam;
  private BaseballTeam awayTeam;
  private Game game;
  private int homeTeamScore;
  private int awayTeamScore;
  private Calendar date = Calendar.getInstance();
  private static final int BASEBALL_WIN = 1;
  private static final int BASEBALL_LOSE = 0;
  private static final int GAME = 1;

  @Before
  public void setUp() throws Exception {
    this.leagueName = "The big bang theory";
    this.startMonths = 6;
    this.endMonths = 9;
    this.numberOfGames = 9;
    this.nextGame = null;
    this.homeTeamScore = 5;
    this.awayTeamScore = 3;
    this.date.set(2018, 6, 15);
    this.baseballLeague = new BaseballLeague(this.leagueName, this.startMonths,
        this.endMonths, this.numberOfGames, this.nextGame);
    this.homeTeam = new BaseballTeam("Attack on Titans", this.baseballLeague, 0,
        this.numberOfGames, 0, null, new Record());
    this.awayTeam = new BaseballTeam("Tokyo Love Story", this.baseballLeague, 0,
        this.numberOfGames, 0, null, new Record());
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
  }

  @Test
  public void playGameHomeTeamWin() {
    this.game = this.baseballLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertTrue(this.date.equals(this.game.getDate()));
    //assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    //assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void playGameAwayTeamWin() {
    this.homeTeamScore = 3;
    this.awayTeamScore = 5;
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
    this.game = this.baseballLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertSame(this.date, this.game.getDate());
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void updateTeamHomeTeamWin() throws Exception {
    BaseballTeam updatedTeam = this.baseballLeague.updateTeam(this.game, homeTeam, Result.WIN);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + BASEBALL_WIN, updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins() + GAME, updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses(), updatedTeam.getRecord().getDraws());
  }

  @Test
  public void updateTeamHomeTeamLose() throws Exception {
    BaseballTeam updatedTeam = this.baseballLeague.updateTeam(this.game, homeTeam, Result.LOSE);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + BASEBALL_LOSE, updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins(), updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses() + GAME,
        updatedTeam.getRecord().getLosses());
  }

}