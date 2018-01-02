package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DigitalInfluenceQuote {
  private static int hc = 0;
  private static DigitalInfluenceQuote instance = null;

  public DigitalInfluenceQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DigitalInfluenceQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DigitalInfluenceQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DigitalInfluenceQuote;
  }

  public String toString() {

    return "<DigitalInfluence>";
  }
}
