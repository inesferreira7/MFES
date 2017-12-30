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
    Number j = 0L;
    VDMSeq celebs = SeqUtil.seq();
    long toVar_9 = celebrities.size();

    for (Long i_2 = 1L; i_2 <= toVar_9; i_2++) {
      long toVar_8 = ((Celebrity) Utils.get(celebrities, i_2)).getActivities().size();

      for (Long j_1 = 1L; j_1 <= toVar_8; j_1++) {
        if (Utils.equals(
            ((Activity) Utils.get(((Celebrity) Utils.get(celebrities, i_2)).getActivities(), j_1))
                .name,
            act.name)) {
          celebs =
              SeqUtil.conc(
                  Utils.copy(celebs), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i_2))));
        }
      }
    }
    return Utils.copy(celebs);
  }

  public Agency getAgencyByName(final String name) {

    Agency a = null;
    Number i = 0L;
    long toVar_10 = agencies.size();

    for (Long i_2 = 1L; i_2 <= toVar_10; i_2++) {
      if (Utils.equals(((Agency) Utils.get(agencies, i_2)).name, name)) {
        return ((Agency) Utils.get(agencies, i_2));
      }
    }
    return a;
  }

  public Celebrity getCelebrityByName(final String name) {

    Celebrity cel = null;
    long toVar_11 = celebrities.size();

    for (Long i = 1L; i <= toVar_11; i++) {
      if (Utils.equals(((Celebrity) Utils.get(celebrities, i)).name, name)) {
        return ((Celebrity) Utils.get(celebrities, i));
      }
    }
    return cel;
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

  public VDMSeq getAgencies() {

    return Utils.copy(agencies);
  }

  public VDMSeq getCelebrityContracts(final Celebrity c) {

    VDMSeq ret = SeqUtil.seq();
    long toVar_13 = agencies.size();

    for (Long i = 1L; i <= toVar_13; i++) {
      long toVar_12 = ((Agency) Utils.get(agencies, i)).getServices().size();

      for (Long j = 1L; j <= toVar_12; j++) {
        if (SetUtil.inSet(
            c,
            SeqUtil.elems(
                ((Service) Utils.get(((Agency) Utils.get(agencies, i)).getServices(), j))
                    .getCelebrities()))) {
          ret = SeqUtil.conc(Utils.copy(ret), SeqUtil.seq(((Agency) Utils.get(agencies, i))));
        }
      }
    }
    return Utils.copy(ret);
  }

  public void removeActivityFromCelebrity(final Celebrity c, final Activity act) {

    c.removeActivity(act);
    long toVar_15 = agencies.size();

    for (Long i = 1L; i <= toVar_15; i++) {
      long toVar_14 = ((Agency) Utils.get(agencies, i)).getServices().size();

      for (Long j = 1L; j <= toVar_14; j++) {
        if (SetUtil.inSet(
            c,
            SeqUtil.elems(
                ((Service) Utils.get(((Agency) Utils.get(agencies, i)).getServices(), j))
                    .getCelebrities()))) {
          ((Agency) Utils.get(agencies, i))
              .fireCelebrity(
                  ((Service) Utils.get(((Agency) Utils.get(agencies, i)).getServices(), j)), c);
        }
      }
    }
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
