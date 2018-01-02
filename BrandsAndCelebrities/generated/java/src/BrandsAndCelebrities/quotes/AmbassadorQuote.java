package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AmbassadorQuote {
  private static int hc = 0;
  private static AmbassadorQuote instance = null;

  public AmbassadorQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AmbassadorQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AmbassadorQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AmbassadorQuote;
  }

  public String toString() {

    return "<Ambassador>";
  }
}
