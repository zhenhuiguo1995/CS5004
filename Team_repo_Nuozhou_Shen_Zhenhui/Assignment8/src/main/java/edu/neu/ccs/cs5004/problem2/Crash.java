package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents details of a crash.
 */
public class Crash {

  private LocalDate date;
  private CrashReason crashReason;

  /**
   * Instantiates a new Crash.
   *
   * @param date -- date of the crash.
   * @param crashReason -- reason of the crash.
   */
  public Crash(LocalDate date, CrashReason crashReason) {
    this.date = date;
    this.crashReason = crashReason;
  }

  /**
   * Get the date.
   *
   * @return the date.
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Get the crashReason.
   *
   * @return the crashReason.
   */
  public CrashReason getCrashReason() {
    return crashReason;
  }

  /**
   * Get toString.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Crash{"
        + "date=" + date
        + ", crashReason=" + crashReason
        + '}';
  }

  /**
   * Check if equals.
   *
   * @param object -- to be checked object.
   * @return true if two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Crash crash = (Crash) object;
    return Objects.equals(date, crash.date) && crashReason == crash.crashReason;
  }

  /**
   * Get the hashCode.
   *
   * @return hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(date, crashReason);
  }
}
