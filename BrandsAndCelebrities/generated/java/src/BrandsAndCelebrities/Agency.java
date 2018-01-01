package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;
import java.io.Serializable;

@SuppressWarnings("all")
public class Agency implements Serializable{
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

    long toVar_1 = services.size();

    for (Long i = 1L; i <= toVar_1; i++) {
      if (Utils.equals(
          ((Service) Utils.get(services, i)).getActivity().name, serv.getActivity().name)) {
        ((Service) Utils.get(services, i)).addCelebrity(cel);
        removeFunds(cel.getPrice());
      }
    }
  }

  public void fireCelebrity(final Service serv, final Celebrity cel) {

    VDMSeq new_serv = SeqUtil.seq();
    long toVar_2 = services.size();

    for (Long i = 1L; i <= toVar_2; i++) {
      if (Utils.equals(((Service) Utils.get(services, i)), serv)) {
        ((Service) Utils.get(services, i)).removeCelebrity(cel);
      }

      if (((Service) Utils.get(services, i)).getCelebrities().size() > 0L) {
        new_serv =
            SeqUtil.conc(Utils.copy(new_serv), SeqUtil.seq(((Service) Utils.get(services, i))));
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

  public Boolean hasService(final String nameS) {

    long toVar_4 = services.size();

    for (Long i = 1L; i <= toVar_4; i++) {
      if (((Service) Utils.get(services, i)).hasActivity(nameS)) {
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
