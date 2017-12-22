package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EmbassadorQuote {
  private static int hc = 0;
  private static EmbassadorQuote instance = null;

  public EmbassadorQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static EmbassadorQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new EmbassadorQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof EmbassadorQuote;
  }

  public String toString() {

    return "<Embassador>";
  }
}
