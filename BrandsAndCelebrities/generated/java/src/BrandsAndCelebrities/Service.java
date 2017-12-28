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

    Number i = 0L;
    VDMSeq new_celebs = SeqUtil.seq();
    long toVar_13 = celebs.size();

    for (Long i_1 = 1L; i_1 <= toVar_13; i_1++) {
      if (!(Utils.equals(((Celebrity) Utils.get(celebs, i_1)), c))) {
        new_celebs =
            SeqUtil.conc(Utils.copy(new_celebs), SeqUtil.seq(((Celebrity) Utils.get(celebs, i_1))));
      }
    }
    celebs = Utils.copy(new_celebs);
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
