package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Platform {
  public static final VDMSet Activity =
      SetUtil.set(
          BrandsAndCelebrities.quotes.EmbassadorQuote.getInstance(),
          BrandsAndCelebrities.quotes.SponsorQuote.getInstance(),
          BrandsAndCelebrities.quotes.EntertainerQuote.getInstance());
  public VDMSeq celebrities = SeqUtil.seq();
  public VDMSeq agencies = SeqUtil.seq();

  public void cg_init_Platform_1() {

    return;
  }

  public Platform() {

    cg_init_Platform_1();
  }

  public VDMSeq getCelebsWithActivity(final Activity act) {

    Number i = 0L;
    VDMSeq celebs = SeqUtil.seq();
    long toVar_4 = celebrities.size();

    for (Long i_2 = 1L; i_2 <= toVar_4; i_2++) {
      if (!(Utils.equals(((Celebrity) Utils.get(celebrities, i_2)).getActivity(), act))) {
        celebs =
            SeqUtil.conc(
                Utils.copy(celebs), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i_2))));
      }
    }
    return Utils.copy(celebs);
  }

  public void addCelebrity(final Celebrity c) {

    celebrities = SeqUtil.conc(Utils.copy(celebrities), SeqUtil.seq(c));
  }

  public void addAgency(final Agency a) {

    agencies = SeqUtil.conc(Utils.copy(agencies), SeqUtil.seq(a));
  }

  public VDMSeq getCelebrities() {

    return Utils.copy(celebrities);
  }

  public String toString() {

    return "Platform{"
        + "Activity = "
        + Utils.toString(Activity)
        + ", celebrities := "
        + Utils.toString(celebrities)
        + ", agencies := "
        + Utils.toString(agencies)
        + "}";
  }
}
