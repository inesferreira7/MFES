package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MusicQuote {
  private static int hc = 0;
  private static MusicQuote instance = null;

  public MusicQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MusicQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MusicQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MusicQuote;
  }

  public String toString() {

    return "<Music>";
  }
}
