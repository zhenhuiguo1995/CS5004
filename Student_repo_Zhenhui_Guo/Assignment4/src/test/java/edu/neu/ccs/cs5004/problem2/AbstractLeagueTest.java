package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AbstractLeagueTest {
  private String leagueName;
  private int startMonths;
  private int endMonths;
  private int numberOfGames;
  private Game nextGame;
  private AbstractLeague abstractLeague;
  private AbstractTeam firstTeam;
  private AbstractTeam secondTeam;
  private Calendar date = Calendar.getInstance();

  @Before
  public void setUp() throws Exception {
    this.leagueName = "American Football Association";
    this.startMonths = 5;
    this.endMonths = 8;
    this.numberOfGames = 8;
    this.nextGame = null;
    this.abstractLeague = new BaseballLeague(this.leagueName, this.startMonths, this.endMonths,
        this.numberOfGames, this.nextGame);
    this.firstTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 0,
        this.numberOfGames, 0, null, new Record());
    this.secondTeam = new BaseballTeam("Tokyo Love Story", this.abstractLeague, 0,
        this.numberOfGames, 0, null, new Record());
  }

  @Test
  public void getLeagueName() throws Exception {
    assertEquals(this.leagueName, this.abstractLeague.getLeagueName());
  }

  @Test
  public void getStartMonths() throws Exception {
    assertEquals(this.startMonths, this.abstractLeague.getStartMonths());
  }

  @Test(expected = IllegalArgumentException.class)
  public void startMonthTooSmall() throws IllegalArgumentException {
    this.startMonths = -1;
    this.abstractLeague = new BaseballLeague(this.leagueName, this.startMonths, this.endMonths,
        this.numberOfGames, this.nextGame);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startMonthOverflow() throws IllegalArgumentException {
    this.startMonths = 12;
    this.abstractLeague = new BaseballLeague(this.leagueName, this.startMonths, this.endMonths,
        this.numberOfGames, this.nextGame);
  }

  @Test(expected = IllegalArgumentException.class)
  public void endMonthTooSmall() throws IllegalArgumentException {
    this.endMonths = -1;
    this.abstractLeague = new BaseballLeague(this.leagueName, this.startMonths, this.endMonths,
        this.numberOfGames, this.nextGame);
  }


  @Test(expected = IllegalArgumentException.class)
  public void endMonthOverflow() throws IllegalArgumentException {
    this.endMonths = 13;
    this.abstractLeague = new BaseballLeague(this.leagueName, this.startMonths, this.endMonths,
        this.numberOfGames, this.nextGame);
  }

  @Test
  public void getEndMonths() throws Exception {
    assertEquals(this.endMonths, this.abstractLeague.getEndMonths());
  }

  @Test
  public void getNumberOfGames() throws Exception {
    assertEquals(this.numberOfGames, this.abstractLeague.getNumberOfGames());
  }

  @Test
  public void getNextGame() throws Exception {
    assertSame(this.nextGame, this.abstractLeague.getNextGame());
  }

  @Test(expected = IllegalArgumentException.class)
  public void compareTeamFromDifferentLeagues() throws IllegalArgumentException, TiedTeamException {
    AbstractLeague abstractLeague = new AmericanFootballLeague(
        "Love Huskies", 6, 8, 7, null);
    this.secondTeam = new BaseballTeam("Tokyo Love Story", abstractLeague, 0,
        this.numberOfGames, 0, null, new Record());
    this.abstractLeague.compareTeam(this.firstTeam, this.secondTeam);
  }

  @Test(expected = TiedTeamException.class)
  public void compareTeamTiedTeam() throws IllegalArgumentException, TiedTeamException {
    this.abstractLeague.compareTeam(this.firstTeam, this.secondTeam);
  }

  @Test
  public void compareTeamFirstTeamHigherPoints() throws IllegalArgumentException, TiedTeamException {
    this.firstTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 0,
        this.numberOfGames, 1, null, new Record());
    assertSame(this.firstTeam, this.abstractLeague.compareTeam(this.firstTeam, this.secondTeam));
  }

  @Test
  public void compareTeamSecondTeamHigherPoints() throws IllegalArgumentException, TiedTeamException {
    this.secondTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 0,
        this.numberOfGames, 1, null, new Record());
    assertSame(this.secondTeam, this.abstractLeague.compareTeam(this.firstTeam, this.secondTeam));
  }

  @Test
  public void compareTeamFirstTeamMoreWins() throws IllegalArgumentException, TiedTeamException {
    this.firstTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 0,
        this.numberOfGames, 0, null, new Record(1, 0, 0));
    assertSame(this.firstTeam, this.abstractLeague.compareTeam(this.firstTeam, this.secondTeam));
  }

  @Test
  public void compareTeamSecondTeamMoreWins() throws IllegalArgumentException, TiedTeamException {
    this.secondTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 0,
        this.numberOfGames, 0, null, new Record(1, 0, 0));
    assertSame(this.secondTeam, this.abstractLeague.compareTeam(this.firstTeam, this.secondTeam));
  }


  @Test(expected = IllegalArgumentException.class)
  public void scheduleGameHomeTeamFinished() throws Exception {
    this.firstTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 8,
        0, 1, null, new Record(1, 7,  0));
    this.date.set(2018, 0, 1);
    this.abstractLeague.scheduleGame(
        this.firstTeam, this.secondTeam, this.date);
  }

  @Test(expected = IllegalArgumentException.class)
  public void scheduleGameAwayTeamFinished() throws Exception {
    this.secondTeam = new BaseballTeam("Attack on Titans", this.abstractLeague, 8,
        0, 1, null, new Record(1, 7,  0));
    this.date.set(2020, 0, 1);
    this.abstractLeague.scheduleGame(
        this.firstTeam, this.secondTeam, this.date);
  }

  @Test
  public void scheduleGame() throws Exception {
    this.date.set(2020, 0, 1);
    AbstractLeague newAbstractLeague = this.abstractLeague.scheduleGame(
        this.firstTeam, this.secondTeam, this.date);
    assertEquals(this.abstractLeague.getLeagueName(), newAbstractLeague.getLeagueName());
    assertEquals(this.abstractLeague.getStartMonths(), newAbstractLeague.getStartMonths());
    assertEquals(this.abstractLeague.getEndMonths(), newAbstractLeague.getEndMonths());
    assertEquals(this.abstractLeague.getNumberOfGames(), newAbstractLeague.getNumberOfGames());
    assertNotSame(this.abstractLeague.getNextGame(), newAbstractLeague.getNextGame());
  }

  @Test
  public void getOnSeason() {
    assertFalse(this.abstractLeague.getOnSeason());
  }


}