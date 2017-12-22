package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EntertainerQuote {
  private static int hc = 0;
  private static EntertainerQuote instance = null;

  public EntertainerQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static EntertainerQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new EntertainerQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof EntertainerQuote;
  }

  public String toString() {

    return "<Entertainer>";
  }
}
