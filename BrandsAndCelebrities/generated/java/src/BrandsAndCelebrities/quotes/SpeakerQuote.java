package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SpeakerQuote {
  private static int hc = 0;
  private static SpeakerQuote instance = null;

  public SpeakerQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SpeakerQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SpeakerQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SpeakerQuote;
  }

  public String toString() {

    return "<Speaker>";
  }
}
