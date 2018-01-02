package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FashionQuote {
  private static int hc = 0;
  private static FashionQuote instance = null;

  public FashionQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FashionQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FashionQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FashionQuote;
  }

  public String toString() {

    return "<Fashion>";
  }
}
