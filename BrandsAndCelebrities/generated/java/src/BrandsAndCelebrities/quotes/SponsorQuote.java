package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SponsorQuote {
  private static int hc = 0;
  private static SponsorQuote instance = null;

  public SponsorQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SponsorQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SponsorQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SponsorQuote;
  }

  public String toString() {

    return "<Sponsor>";
  }
}
