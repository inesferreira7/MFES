package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PlatformTest {
  private Platform p = new Platform();
  private Celebrity c = new Celebrity("cel1", 80L);
  private Celebrity c2 = new Celebrity("cel2", 90L);
  private Agency a = new Agency("ag1");
  private Activity act = new Activity("Sponsor");
  private Activity act2 = new Activity("Entertainer");
  private Service s = new Service(act2);

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testGets() {

    IO.print("\nTesting get functions...\n");
    assertTrue(Utils.empty(p.getCelebrities()));
  }

  private void testAddCelebrity() {

    IO.print("\nTesting add celebrity to platform...\n");
    p.addCelebrity(c);
    assertTrue(Utils.equals(p.getCelebrities(), SeqUtil.seq(c)));
  }

  private void testAddAgency() {

    IO.print("\nTesting add agency to platform...\n");
    p.addAgency(a);
    assertTrue(Utils.equals(p.getAgencies(), SeqUtil.seq(a)));
  }

  private void testAgencyByName() {

    p.addAgency(a);
    IO.print("\nTesting get agency by name \n");
    assertTrue(Utils.equals(p.getAgencyByName("ag1"), a));
  }

  private void testCelebrityByName() {

    p.addCelebrity(c);
    IO.print("\nTesting get celebrity by name \n");
    assertTrue(Utils.equals(p.getCelebrityByName("cel1"), c));
    assertTrue(Utils.equals(p.getCelebrityByName("cel3"), null));
  }

  private void testCelebsWithActivity() {

    IO.print("\nTesting get celebrities with given activity \n");
    c.addActivity(act);
    c2.addActivity(act);
    p.addCelebrity(c);
    p.addCelebrity(c2);
    assertTrue(Utils.equals(p.getCelebsWithActivity(act), SeqUtil.seq(c, c2)));
  }

  private void testRemoveActivity() {

    IO.print("\nTesting remove activity from celebrity \n");
    c.addActivity(act);
    c.addActivity(act2);
    p.addCelebrity(c);
    s.addCelebrity(c);
    a.addService(s);
    p.addAgency(a);
    assertTrue(Utils.equals(c.getActivities(), SeqUtil.seq(act, act2)));
    assertTrue(Utils.equals(s.getCelebrities(), SeqUtil.seq(c)));
    p.removeActivityFromCelebrity(c, act);
    assertTrue(Utils.equals(c.getActivities(), SeqUtil.seq(act2)));
    assertTrue(Utils.empty(s.getCelebrities()));
  }

  private void testCelebContracts() {

    IO.print("\n Testing get celebrity contracts \n");
    c.addActivity(act2);
    s.addCelebrity(c);
    a.addService(s);
    p.addAgency(a);
    assertTrue(Utils.equals(p.getCelebrityContracts(c), SeqUtil.seq(a)));
  }

  public static void runTests() {

    IO.print("*** Running Platform tests ***\n");
    new PlatformTest().testGets();
    new PlatformTest().testAddCelebrity();
    new PlatformTest().testAddAgency();
    new PlatformTest().testAgencyByName();
    new PlatformTest().testCelebrityByName();
    new PlatformTest().testCelebsWithActivity();
    new PlatformTest().testRemoveActivity();
    new PlatformTest().testCelebContracts();
  }

  public PlatformTest() {}

  public String toString() {

    return "PlatformTest{"
        + "p := "
        + Utils.toString(p)
        + ", c := "
        + Utils.toString(c)
        + ", c2 := "
        + Utils.toString(c2)
        + ", a := "
        + Utils.toString(a)
        + ", act := "
        + Utils.toString(act)
        + ", act2 := "
        + Utils.toString(act2)
        + ", s := "
        + Utils.toString(s)
        + "}";
  }
}
