package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ConsultoryQuote {
  private static int hc = 0;
  private static ConsultoryQuote instance = null;

  public ConsultoryQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ConsultoryQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ConsultoryQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ConsultoryQuote;
  }

  public String toString() {

    return "<Consultory>";
  }
}
