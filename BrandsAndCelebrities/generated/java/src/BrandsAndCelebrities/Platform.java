package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Platform {
  public static final VDMSet Activity =
      SetUtil.set(
          BrandsAndCelebrities.quotes.AmbassadorQuote.getInstance(),
          BrandsAndCelebrities.quotes.SponsorQuote.getInstance(),
          BrandsAndCelebrities.quotes.EntertainerQuote.getInstance(),
          BrandsAndCelebrities.quotes.SpeakerQuote.getInstance(),
          BrandsAndCelebrities.quotes.DigitalInfluenceQuote.getInstance(),
          BrandsAndCelebrities.quotes.ProductPlacementQuote.getInstance(),
          BrandsAndCelebrities.quotes.AttendanceQuote.getInstance());
  public static final VDMSet Setor =
      SetUtil.set(
          BrandsAndCelebrities.quotes.NutritionQuote.getInstance(),
          BrandsAndCelebrities.quotes.DecorationQuote.getInstance(),
          BrandsAndCelebrities.quotes.ConsultoryQuote.getInstance(),
          BrandsAndCelebrities.quotes.MusicQuote.getInstance(),
          BrandsAndCelebrities.quotes.CinemaQuote.getInstance(),
          BrandsAndCelebrities.quotes.TechnologyQuote.getInstance(),
          BrandsAndCelebrities.quotes.FashionQuote.getInstance());
  public VDMSeq celebrities = SeqUtil.seq();
  public VDMSeq agencies = SeqUtil.seq();

  public void cg_init_Platform_1() {

    return;
  }

  public Platform() {

    cg_init_Platform_1();
  }

  public VDMSeq getCelebsWithActivity(final Activity act) {

    VDMSeq celebs = SeqUtil.seq();
    long toVar_9 = celebrities.size();

    for (Long i = 1L; i <= toVar_9; i++) {
      long toVar_8 = ((Celebrity) Utils.get(celebrities, i)).getActivities().size();

      for (Long j = 1L; j <= toVar_8; j++) {
        if (Utils.equals(
            ((Activity) Utils.get(((Celebrity) Utils.get(celebrities, i)).getActivities(), j)).name,
            act.name)) {
          celebs =
              SeqUtil.conc(
                  Utils.copy(celebs), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i))));
        }
      }
    }
    return Utils.copy(celebs);
  }

  public VDMSeq getCelebsWithSetor(final Setor s) {

    VDMSeq celebs = SeqUtil.seq();
    long toVar_11 = celebrities.size();

    for (Long i = 1L; i <= toVar_11; i++) {
      long toVar_10 = ((Celebrity) Utils.get(celebrities, i)).getSetors().size();

      for (Long j = 1L; j <= toVar_10; j++) {
        if (Utils.equals(
            ((Setor) Utils.get(((Celebrity) Utils.get(celebrities, i)).getSetors(), j)).name,
            s.name)) {
          celebs =
              SeqUtil.conc(
                  Utils.copy(celebs), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i))));
        }
      }
    }
    return Utils.copy(celebs);
  }

  public VDMSet getCelebsWithActivityAndSetor(final Activity a, final Setor s) {

    VDMSet cA = SetUtil.set();
    VDMSet cS = SetUtil.set();
    VDMSet result = SetUtil.set();
    cA = SeqUtil.elems(getCelebsWithActivity(a));
    cS = SeqUtil.elems(getCelebsWithSetor(s));
    result = SetUtil.intersect(Utils.copy(cA), Utils.copy(cS));
    return Utils.copy(result);
  }

  public Agency getAgencyByName(final String name) {

    Agency a = null;
    long toVar_12 = agencies.size();

    for (Long i = 1L; i <= toVar_12; i++) {
      if (Utils.equals(((Agency) Utils.get(agencies, i)).name, name)) {
        return ((Agency) Utils.get(agencies, i));
      }
    }
    return a;
  }

  public Celebrity getCelebrityByName(final String name) {

    Celebrity cel = null;
    long toVar_13 = celebrities.size();

    for (Long i = 1L; i <= toVar_13; i++) {
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
    long toVar_15 = agencies.size();

    for (Long i = 1L; i <= toVar_15; i++) {
      long toVar_14 = ((Agency) Utils.get(agencies, i)).getServices().size();

      for (Long j = 1L; j <= toVar_14; j++) {
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
    long toVar_17 = agencies.size();

    for (Long i = 1L; i <= toVar_17; i++) {
      long toVar_16 = ((Agency) Utils.get(agencies, i)).getServices().size();

      for (Long j = 1L; j <= toVar_16; j++) {
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

  public Boolean celebrityExists(final String name) {

    VDMSeq aux = SeqUtil.seq();
    long toVar_18 = celebrities.size();

    for (Long i = 1L; i <= toVar_18; i++) {
      aux =
          SeqUtil.conc(Utils.copy(aux), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i)).name));
    }
    return SetUtil.inSet(name, SeqUtil.elems(Utils.copy(aux)));
  }

  public Boolean agencyExists(final String name) {

    VDMSeq aux = SeqUtil.seq();
    long toVar_19 = agencies.size();

    for (Long i = 1L; i <= toVar_19; i++) {
      aux = SeqUtil.conc(Utils.copy(aux), SeqUtil.seq(((Agency) Utils.get(agencies, i)).name));
    }
    return SetUtil.inSet(name, SeqUtil.elems(Utils.copy(aux)));
  }

  public VDMSeq getCelebritiesByPrice(final Number price) {

    VDMSeq ret = SeqUtil.seq();
    long toVar_20 = celebrities.size();

    for (Long i = 1L; i <= toVar_20; i++) {
      if (((Celebrity) Utils.get(celebrities, i)).getPrice().longValue() <= price.longValue()) {
        ret = SeqUtil.conc(Utils.copy(ret), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i))));
      }
    }
    return Utils.copy(ret);
  }

  public VDMSeq getCelebritiesByRating(final Number rating) {

    VDMSeq ret = SeqUtil.seq();
    long toVar_21 = celebrities.size();

    for (Long i = 1L; i <= toVar_21; i++) {
      if (((Celebrity) Utils.get(celebrities, i)).getRating().longValue() >= rating.longValue()) {
        ret = SeqUtil.conc(Utils.copy(ret), SeqUtil.seq(((Celebrity) Utils.get(celebrities, i))));
      }
    }
    return Utils.copy(ret);
  }

  public String toString() {

    return "Platform{"
        + "Activity = "
        + Utils.toString(Activity)
        + ", Setor = "
        + Utils.toString(Setor)
        + ", celebrities := "
        + Utils.toString(celebrities)
        + ", agencies := "
        + Utils.toString(agencies)
        + "}";
  }
}
