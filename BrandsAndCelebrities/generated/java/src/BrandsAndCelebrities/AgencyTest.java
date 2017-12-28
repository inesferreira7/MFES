package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AgencyTest {
  private Agency a = new Agency("test");
  private Activity act = new Activity("test");
  private Celebrity c = new Celebrity("Test Celebrity", 35L);
  private Service s = new Service(act);

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testAddRemoveFunds() {

    IO.print("\n* Test adding and removing funds to an Agency *\n");
    IO.print("Current Funds: ");
    IO.print(a.getFunds());
    IO.print("€\n");
    IO.print("Adding 100€...\n");
    a.addFunds(100L);
    assertTrue(Utils.equals(a.getFunds(), 100L));
    IO.print("Current Funds: ");
    IO.print(a.getFunds());
    IO.print("€\n");
    IO.print("Removing 50€...\n");
    a.removeFunds(50L);
    assertTrue(Utils.equals(a.getFunds(), 50L));
    IO.print("Current Funds: ");
    IO.print(a.getFunds());
    IO.print("€\n");
  }

  private void testHireFireCelebritytoService() {

    IO.print("\n* Test hiring and firing celebrities to the Agency *\n");
    IO.print("\nAdding 100€ to the funds...\n");
    a.addFunds(100L);
    IO.print("Adding a new service to the Agency...\n");
    assertTrue(Utils.empty(a.getServices()));
    a.addService(s);
    assertTrue(Utils.equals(a.getServices(), SeqUtil.seq(s)));
    IO.print("Services of the Agency: ");
    IO.print(((Service) Utils.get(a.getServices(), 1L)));
    IO.print("\n");
    IO.print("Celebrities hired to that service: ");
    IO.print(((Service) Utils.get(a.getServices(), 1L)).getCelebrities().size());
    IO.print("\n");
    assertTrue(Utils.empty(((Service) Utils.get(a.getServices(), 1L)).getCelebrities()));
    IO.print("Adding a new celebrity to the service...\n");
    a.hireCelebrity(s, c);
    assertTrue(
        Utils.equals(((Service) Utils.get(a.getServices(), 1L)).getCelebrities(), SeqUtil.seq(c)));
    IO.print("Celebrities hired to that service: ");
    IO.print(
        ((Celebrity) Utils.get(((Service) Utils.get(a.getServices(), 1L)).getCelebrities(), 1L)));
    IO.print("\n");
    IO.print("Firing the previous celebrity from the service...\n");
    a.fireCelebrity(c);
    assertTrue(Utils.empty(((Service) Utils.get(a.getServices(), 1L)).getCelebrities()));
    IO.print("Celebrities hired to that service: ");
    IO.print(((Service) Utils.get(a.getServices(), 1L)).getCelebrities().size());
    IO.print("\n");
  }

  private void testGets() {

    IO.print("\nTesting get functions...\n");
    assertTrue(Utils.equals(a.getFunds(), 0L));
    assertTrue(Utils.empty(a.getServices()));
  }

  public static void runTests() {

    IO.print("*** Running Agency tests ***\n");
    new AgencyTest().testAddRemoveFunds();
    new AgencyTest().testHireFireCelebritytoService();
    new AgencyTest().testGets();
  }

  public AgencyTest() {}

  public String toString() {

    return "AgencyTest{"
        + "a := "
        + Utils.toString(a)
        + ", act := "
        + Utils.toString(act)
        + ", c := "
        + Utils.toString(c)
        + ", s := "
        + Utils.toString(s)
        + "}";
  }
}
