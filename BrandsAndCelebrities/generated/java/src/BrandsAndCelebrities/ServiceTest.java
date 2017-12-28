package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ServiceTest {
  private Activity act = new Activity("test");
  private Service s = new Service(act);

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testAddRemoveCelebrity() {

    IO.print("* Test adding and removing celebrities from a service *\n");
    IO.print("\nAdding 2 celebrities to the service...\n");
    IO.print("Current celebrities: ");
    IO.print(((Celebrity) Utils.get(s.getCelebrities(), 1L)));
    IO.print(((Celebrity) Utils.get(s.getCelebrities(), 2L)));
    IO.print("\n");
    IO.print("Removing the first celebrity...\n");
    IO.print("Current celebrities: ");
    IO.print(((Celebrity) Utils.get(s.getCelebrities(), 1L)));
    IO.print("\n");
  }

  private void testGets() {

    IO.print("\nTesting get functions...\n");
    assertTrue(Utils.equals(s.getActivity(), act));
    assertTrue(Utils.empty(s.getCelebrities()));
  }

  public static void runTests() {

    IO.print("*** Running Service tests ***\n");
    new ServiceTest().testGets();
    new ServiceTest().testAddRemoveCelebrity();
  }

  public ServiceTest() {}

  public String toString() {

    return "ServiceTest{" + "act := " + Utils.toString(act) + ", s := " + Utils.toString(s) + "}";
  }
}
