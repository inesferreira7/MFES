package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Celebrity {
  public String name;
  private VDMSeq activities = SeqUtil.seq();
  private Number rating;
  private Number price;

  public void cg_init_Celebrity_1(final String nm, final Number prc) {

    name = nm;
    rating = MATH.rand(4L).longValue() + 1L;
    price = prc;
  }

  public Celebrity(final String nm, final Number prc) {

    cg_init_Celebrity_1(nm, prc);
  }

  public VDMSeq getActivities() {

    return Utils.copy(activities);
  }

  public Number getRating() {

    return rating;
  }

  public Number getPrice() {

    return price;
  }

  public void addActivity(final Activity a) {

    activities = SeqUtil.conc(Utils.copy(activities), SeqUtil.seq(a));
  }

  public Celebrity() {}

  public String toString() {

    return "Celebrity{"
        + "name := "
        + Utils.toString(name)
        + ", activities := "
        + Utils.toString(activities)
        + ", rating := "
        + Utils.toString(rating)
        + ", price := "
        + Utils.toString(price)
        + "}";
  }
}
