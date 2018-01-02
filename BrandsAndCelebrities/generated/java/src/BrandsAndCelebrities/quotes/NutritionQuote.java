package BrandsAndCelebrities.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NutritionQuote {
  private static int hc = 0;
  private static NutritionQuote instance = null;

  public NutritionQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static NutritionQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new NutritionQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof NutritionQuote;
  }

  public String toString() {

    return "<Nutrition>";
  }
}
