package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ServiceTest {
  private Activity act = new Activity("test");
  private Service s = new Service(act);
  private Setor s1 = new Setor("Techonology");
  private Celebrity c1 = new Celebrity("Test Celebrity 1", 35L, SeqUtil.seq(s1));
  private Celebrity c2 = new Celebrity("Test Celebrity 2", 27L, SeqUtil.seq(s1));

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testAddRemoveCelebrity() {

    c1.addActivity(act);
    c2.addActivity(act);
    IO.print("* Test adding and removing celebrities from a service *\n");
    IO.print("\nAdding 2 celebrities to the service...\n");
    s.addCelebrity(c1);
    s.addCelebrity(c2);
    assertTrue(Utils.equals(s.getCelebrities(), SeqUtil.seq(c1, c2)));
    IO.print("Current celebrities: ");
    IO.print(((Celebrity) Utils.get(s.getCelebrities(), 1L)));
    IO.print(((Celebrity) Utils.get(s.getCelebrities(), 2L)));
    IO.print("\n");
    IO.print("Removing the first celebrity...\n");
    s.removeCelebrity(c1);
    assertTrue(Utils.equals(s.getCelebrities(), SeqUtil.seq(c2)));
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

    return "ServiceTest{"
        + "act := "
        + Utils.toString(act)
        + ", s := "
        + Utils.toString(s)
        + ", s1 := "
        + Utils.toString(s1)
        + ", c1 := "
        + Utils.toString(c1)
        + ", c2 := "
        + Utils.toString(c2)
        + "}";
  }
}
