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

  public void removeActivity(final Activity a) {

    VDMSeq new_act = SeqUtil.seq();
    long toVar_4 = activities.size();

    for (Long i = 1L; i <= toVar_4; i++) {
      if (!(Utils.equals(((Activity) Utils.get(activities, i)), a))) {
        new_act =
            SeqUtil.conc(Utils.copy(new_act), SeqUtil.seq(((Activity) Utils.get(activities, i))));
      }
    }
    activities = Utils.copy(new_act);
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
