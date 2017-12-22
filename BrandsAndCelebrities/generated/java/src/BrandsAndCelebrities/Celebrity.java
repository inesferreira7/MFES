package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Celebrity {
  public String name;
  private Activity activity;
  private Number rating;
  private Number price;

  public void cg_init_Celebrity_1(
      final String nm, final Activity act, final Number rt, final Number prc) {

    name = nm;
    activity = act;
    rating = rt;
    price = prc;
  }

  public Celebrity(final String nm, final Activity act, final Number rt, final Number prc) {

    cg_init_Celebrity_1(nm, act, rt, prc);
  }

  public Activity getActivity() {

    return activity;
  }

  public Number getRating() {

    return rating;
  }

  public Number getPrice() {

    return price;
  }

  public Celebrity() {}

  public String toString() {

    return "Celebrity{"
        + "name := "
        + Utils.toString(name)
        + ", activity := "
        + Utils.toString(activity)
        + ", rating := "
        + Utils.toString(rating)
        + ", price := "
        + Utils.toString(price)
        + "}";
  }
}
