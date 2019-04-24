package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class SoccerLeagueTest {
  private String leagueName;
  private int startMonths;
  private int endMonths;
  private int numberOfGames;
  private Game nextGame;
  private SoccerLeague soccerLeague;
  private SoccerTeam homeTeam;
  private SoccerTeam awayTeam;
  private Game game;
  private int homeTeamScore;
  private int awayTeamScore;
  private Calendar date = Calendar.getInstance();
  private static final int SOCCER_WIN = 3;
  private static final int SOCCER_DRAW = 1;
  private static final int SOCCER_LOSE = 0;
  private static final int GAME = 1;


  @Before
  public void setUp() throws Exception {
    this.leagueName = "King's Guard";
    this.startMonths = 2;
    this.endMonths = 5;
    this.numberOfGames = 6;
    this.nextGame = null;
    this.homeTeamScore = 3;
    this.awayTeamScore = 2;
    date.set(2019, 3, 9);
    this.soccerLeague = new SoccerLeague(this.leagueName, this.startMonths,
        this.endMonths, this.numberOfGames, this.nextGame);
    this.homeTeam = new SoccerTeam("Winterfell Team", this.soccerLeague,
        0, this.numberOfGames, 0, null, new Record());
    this.awayTeam = new SoccerTeam("Fearford Strippers",
        this.soccerLeague, 0, this.numberOfGames, 0,
        null, new Record());
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
  }

  @Test
  public void scheduleGameForLeague() throws Exception {
    this.soccerLeague.createGameForLeague(this.leagueName, this.startMonths,
        this.endMonths, this.numberOfGames, this.game);
  }

  @Test
  public void playGameHomeTeamWin() {
    this.game = this.soccerLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
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
    this.game = this.soccerLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertSame(this.date, this.game.getDate());
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void playGameTieGame() {
    this.homeTeamScore = this.awayTeamScore;
    this.game = new Game(this.homeTeam, this.awayTeam, this.date,
        this.homeTeamScore, this.awayTeamScore);
    this.game = this.soccerLeague.playGame(this.game, this.homeTeamScore, this.awayTeamScore);
    assertSame(this.date, this.game.getDate());
    assertEquals(this.homeTeamScore, this.game.getHomeTeamScore());
    assertEquals(this.awayTeamScore, this.game.getAwayTeamScore());
  }

  @Test
  public void updateTeamHomeTeamWin() throws Exception {
    SoccerTeam updatedTeam = (SoccerTeam) this.soccerLeague.updateTeam(this.game,
        homeTeam, Result.WIN);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + SOCCER_WIN, updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins() + GAME, updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses(), updatedTeam.getRecord().getDraws());
  }

  @Test
  public void updateTeamHomeTeamLose() throws Exception {
    SoccerTeam updatedTeam = (SoccerTeam) this.soccerLeague.updateTeam(this.game, homeTeam, Result.LOSE);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + SOCCER_LOSE,
        updatedTeam.getPoints());
    assertEquals(this.homeTeam.getGamePlayed() + GAME, updatedTeam.getGamePlayed());
    assertEquals(this.homeTeam.getGameRemaining() - GAME, updatedTeam.getGameRemaining());
    assertEquals(this.homeTeam.getRecord().getWins(), updatedTeam.getRecord().getWins());
    assertEquals(this.homeTeam.getRecord().getLosses() + GAME,
        updatedTeam.getRecord().getLosses());
  }

  @Test
  public void updateTeamDrawGame() throws Exception {
    SoccerTeam updatedTeam = (SoccerTeam) this.soccerLeague.updateTeam(this.game, homeTeam, Result.TIE);
    assertEquals(this.homeTeam.getName(), updatedTeam.getName());
    assertEquals(this.homeTeam.getAbstractLeague(), updatedTeam.getAbstractLeague());
    assertEquals(this.homeTeam.getPoints() + SOCCER_DRAW,
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