package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TechnologyQuote {
  private static int hc = 0;
  private static TechnologyQuote instance = null;

  public TechnologyQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static TechnologyQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new TechnologyQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof TechnologyQuote;
  }

  public String toString() {

    return "<Technology>";
  }
}
