package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CinemaQuote {
  private static int hc = 0;
  private static CinemaQuote instance = null;

  public CinemaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CinemaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CinemaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CinemaQuote;
  }

  public String toString() {

    return "<Cinema>";
  }
}
