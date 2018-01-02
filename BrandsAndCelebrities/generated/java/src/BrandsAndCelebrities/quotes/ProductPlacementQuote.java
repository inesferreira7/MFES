package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ProductPlacementQuote {
  private static int hc = 0;
  private static ProductPlacementQuote instance = null;

  public ProductPlacementQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ProductPlacementQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ProductPlacementQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ProductPlacementQuote;
  }

  public String toString() {

    return "<ProductPlacement>";
  }
}
