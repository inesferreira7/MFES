package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Agency {
  public String name;
  private Number funds = 0L;
  private VDMSeq services = SeqUtil.seq();

  public void cg_init_Agency_1(final String nm) {

    name = nm;
  }

  public Agency(final String nm) {

    cg_init_Agency_1(nm);
  }

  public Number getFunds() {

    return funds;
  }

  public VDMSeq getServices() {

    return Utils.copy(services);
  }

  public void addFunds(final Number qty) {

    funds = funds.longValue() + qty.longValue();
  }

  public void removeFunds(final Number qty) {

    funds = funds.longValue() - qty.longValue();
  }

  public void addService(final Service srv) {

    services = SeqUtil.conc(Utils.copy(services), SeqUtil.seq(srv));
  }

  public void hireCelebrity(final Service serv, final Celebrity cel) {

    Number i = 0L;
    long toVar_1 = services.size();

    for (Long i_1 = 1L; i_1 <= toVar_1; i_1++) {
      if (Utils.equals(
          ((Service) Utils.get(services, i_1)).getActivity().name, serv.getActivity().name)) {
        ((Service) Utils.get(services, i_1)).addCelebrity(cel);
        removeFunds(cel.getPrice());
      }
    }
  }

  public void fireCelebrity(final Service serv, final Celebrity cel) {

    Number i = 0L;
    VDMSeq new_serv = SeqUtil.seq();
    long toVar_2 = services.size();

    for (Long i_1 = 1L; i_1 <= toVar_2; i_1++) {
      if (Utils.equals(((Service) Utils.get(services, i_1)), serv)) {
        ((Service) Utils.get(services, i_1)).removeCelebrity(cel);
      }

      if (((Service) Utils.get(services, i_1)).getCelebrities().size() > 0L) {
        new_serv =
            SeqUtil.conc(Utils.copy(new_serv), SeqUtil.seq(((Service) Utils.get(services, i_1))));
      }
    }
    services = Utils.copy(new_serv);
  }

  public VDMSeq findServiceByCelebrity(final Celebrity c) {

    VDMSeq ret = SeqUtil.seq();
    long toVar_3 = services.size();

    for (Long i = 1L; i <= toVar_3; i++) {
      if (SetUtil.inSet(c, SeqUtil.elems(((Service) Utils.get(services, i)).getCelebrities()))) {
        ret = SeqUtil.conc(Utils.copy(ret), SeqUtil.seq(((Service) Utils.get(services, i))));
      }
    }
    return Utils.copy(ret);
  }

  public Boolean hasService(final String name_1) {

    long toVar_4 = services.size();

    for (Long i = 1L; i <= toVar_4; i++) {
      if (((Service) Utils.get(services, i)).hasActivity(name_1)) {
        return true;
      }
    }
    return false;
  }

  public Boolean hasServiceWithCelebrity(final String nameS, final Celebrity cel) {

    long toVar_5 = services.size();

    for (Long i = 1L; i <= toVar_5; i++) {
      if (((Service) Utils.get(services, i)).hasActivity(nameS)) {
        if (SetUtil.inSet(
            cel, SeqUtil.elems(((Service) Utils.get(services, i)).getCelebrities()))) {
          return true;
        }
      }
    }
    return false;
  }

  public Agency() {}

  public String toString() {

    return "Agency{"
        + "name := "
        + Utils.toString(name)
        + ", funds := "
        + Utils.toString(funds)
        + ", services := "
        + Utils.toString(services)
        + "}";
  }
}
