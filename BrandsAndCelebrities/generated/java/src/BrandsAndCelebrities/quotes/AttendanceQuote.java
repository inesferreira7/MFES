package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AttendanceQuote {
  private static int hc = 0;
  private static AttendanceQuote instance = null;

  public AttendanceQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AttendanceQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AttendanceQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AttendanceQuote;
  }

  public String toString() {

    return "<Attendance>";
  }
}
