package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CelebrityTest {
  private Activity act = new Activity("test");
  private Setor s = new Setor("Techonology");
  private Celebrity c = new Celebrity("Test Celebrity", 35L, SeqUtil.seq(s));

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testAddActivity() {

    IO.print("\nTesting add activity to celebrity...\n");
    c.addActivity(act);
    assertTrue(Utils.equals(c.getActivities(), SeqUtil.seq(act)));
    assertTrue(Utils.equals(c.hasActivity("test"), true));
    assertTrue(Utils.equals(c.hasActivity("test2"), false));
  }

  private void testGets() {

    IO.print("\nTesting get functions...\n");
    assertTrue(Utils.empty(c.getActivities()));
    Boolean andResult_23 = false;

    if (c.getRating().longValue() > 0L) {
      if (c.getRating().longValue() < 6L) {
        andResult_23 = true;
      }
    }

    assertTrue(andResult_23);

    assertTrue(Utils.equals(c.getPrice(), 35L));
  }

  public static void runTests() {

    IO.print("*** Running Celebrity tests ***\n");
    new CelebrityTest().testGets();
    new CelebrityTest().testAddActivity();
  }

  public CelebrityTest() {}

  public String toString() {

    return "CelebrityTest{"
        + "act := "
        + Utils.toString(act)
        + ", s := "
        + Utils.toString(s)
        + ", c := "
        + Utils.toString(c)
        + "}";
  }
}
