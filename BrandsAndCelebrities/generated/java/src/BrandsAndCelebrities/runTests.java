package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class runTests {
  private AgencyTest at1 = new AgencyTest();
  private CelebrityTest ct1 = new CelebrityTest();
  private ServiceTest st1 = new ServiceTest();
  private PlatformTest pt1 = new PlatformTest();

  public void main() {

    IO.print("***** Running all tests *****\n");
    at1.runTests();
    IO.print("\n\n");
    ct1.runTests();
    IO.print("\n\n");
    st1.runTests();
    IO.print("\n\n");
    pt1.runTests();
    IO.print("\n\n");
    IO.print("***** Finished running the tests *****\n");
  }

  public runTests() {}

  public String toString() {

    return "runTests{"
        + "at1 := "
        + Utils.toString(at1)
        + ", ct1 := "
        + Utils.toString(ct1)
        + ", st1 := "
        + Utils.toString(st1)
        + ", pt1 := "
        + Utils.toString(pt1)
        + "}";
  }
}
