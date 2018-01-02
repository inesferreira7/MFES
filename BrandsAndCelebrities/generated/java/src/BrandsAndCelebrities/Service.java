package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Service {
  private Activity activity;
  private VDMSeq celebs = SeqUtil.seq();

  public void cg_init_Service_1(final Activity act) {

    activity = act;
  }

  public Service(final Activity act) {

    cg_init_Service_1(act);
  }

  public Activity getActivity() {

    return activity;
  }

  public VDMSeq getCelebrities() {

    return Utils.copy(celebs);
  }

  public void addCelebrity(final Celebrity c) {

    celebs = SeqUtil.conc(Utils.copy(celebs), SeqUtil.seq(c));
  }

  public void removeCelebrity(final Celebrity c) {

    VDMSeq new_celebs = SeqUtil.seq();
    long toVar_22 = celebs.size();

    for (Long i = 1L; i <= toVar_22; i++) {
      if (!(Utils.equals(((Celebrity) Utils.get(celebs, i)), c))) {
        new_celebs =
            SeqUtil.conc(Utils.copy(new_celebs), SeqUtil.seq(((Celebrity) Utils.get(celebs, i))));
      }
    }
    celebs = Utils.copy(new_celebs);
  }

  public Boolean hasActivity(final String name) {

    if (Utils.equals(activity.name, name)) {
      return true;
    }

    return false;
  }

  public Service() {}

  public String toString() {

    return "Service{"
        + "activity := "
        + Utils.toString(activity)
        + ", celebs := "
        + Utils.toString(celebs)
        + "}";
  }
}
