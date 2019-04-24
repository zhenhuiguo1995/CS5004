package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AmericanFootballLeagueTest {
  private String leagueName;
  private int startMonths;
  private int endMonths;
  private int numberOfGames;
  private Game nextGame;
  private AmericanFootballLeague americanFootballLeague;
  private AmericanFootballTeam homeTeam;
  private AmericanFootballTeam awayTeam;
  private Game game;
  private int homeTeamScore;
  private int awayTeamScore;
  private Calendar date = Calendar.getInstance();
  private static final int AMERICAN_FOOTBALL_WIN = 1;
  private static final int AMERICAN_FOOTBALL_LOSE_OR_DRAW = 0;
  private static final int GAME = 1;


  @Before
  public void setUp() throws Exception {
    this.leagueName = "The North";
    this.startMonths = 9;
    this.endMonths = 11;
    this.numberOfGames = 12;
    this.nextGame = null;
    this.homeTeamScore = 18;
    this.awayTeamScore = 13;
    this.date.set(2019, 11, 9);
    this.americanFootballLeague = new AmericanFootballLeague(this.leagueName, this.startMonths,
        this.endMonths, this.numberOfGames, this.nextGame);
    this.homeTeam = new AmericanFootballTeam("Winterfell Team", this.americanFootballLeague,
        0, this.numberOfGames, 0, null, new Record());
    this.awayTeam = new AmericanFootballTeam("Fearford Strippers",
        this.americanFootballLeague, 0, this.numberOfGames, 0,
        null, new Record());
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
  }

  @Test
  public void scheduleGameForLeague() throws Exception {
    this.americanFootballLeague.createGameForLeague(this.leagueName, this.startMonths,
        this.endMonths, this.numberOfGames, this.game);
  }

  @Test
  public void playGameHomeTeamWin() {
    this.game = this.americanFootballLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertSame(this.date, this.game.getDate());
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void playGameAwayTeamWin() {
    this.homeTeamScore = 13;
    this.awayTeamScore = 20;
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
    this.game = this.americanFootballLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertSame(this.date, this.game.getDate());
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void playGameTieGame() {
    this.homeTeamScore = this.awayTeamScore;
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
    this.game = this.americanFootballLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertSame(this.date, this.game.getDate());
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void updateTeamHomeTeamWin() throws Exception {
    AmericanFootballTeam updatedTeam = (AmericanFootballTeam) this.americanFootballLeague.updateTeam(this.game,
        homeTeam, Result.WIN);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    System.out.println(updatedTeam.getPoints());
    assertEquals(this.homeTeam.getPoints() + AMERICAN_FOOTBALL_WIN, updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins() + GAME, updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses(), updatedTeam.getRecord().getDraws());
  }

  @Test
  public void updateTeamHomeTeamLose() throws Exception {
    AmericanFootballTeam updatedTeam = (AmericanFootballTeam) this.americanFootballLeague.updateTeam(this.game, homeTeam, Result.LOSE);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + AMERICAN_FOOTBALL_LOSE_OR_DRAW,
        updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins(), updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses() + GAME,
        updatedTeam.getRecord().getLosses());
  }

  @Test
  public void updateTeamDrawGame() throws Exception {
    AmericanFootballTeam updatedTeam = (AmericanFootballTeam) this.americanFootballLeague.updateTeam(this.game, homeTeam, Result.TIE);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + AMERICAN_FOOTBALL_LOSE_OR_DRAW,
        updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins(), updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses(),
        updatedTeam.getRecord().getLosses());
    assertEquals(this.homeTeam.getRecord().getDraws() + GAME,
        updatedTeam.getRecord().getDraws());
  }

}