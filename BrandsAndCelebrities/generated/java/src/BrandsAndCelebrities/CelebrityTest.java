package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CelebrityTest {
  private Activity old_act = new Activity("test");
  private Activity new_act = new Activity("change_test");

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void testChangeActivity() {

    IO.print("\n* Test changing the activity of the celebrity *\n");
    IO.print("\nCurrent Activity: ");
    IO.print(old_act);
    IO.print("\n");
    IO.print("Changing activity...\n");
    IO.print("Current Activity: ");
    IO.print(new_act);
    IO.print("\n");
  }

  private void testGets() {

    IO.print("\nTesting get functions...\n");
  }

  public static void runTests() {

    IO.print("*** Running Celebrity tests ***\n");
    new CelebrityTest().testGets();
    new CelebrityTest().testChangeActivity();
  }

  public CelebrityTest() {}

  public String toString() {

    return "CelebrityTest{"
        + "old_act := "
        + Utils.toString(old_act)
        + ", new_act := "
        + Utils.toString(new_act)
        + "}";
  }
}
