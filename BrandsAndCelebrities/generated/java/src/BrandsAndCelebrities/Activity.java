package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;
import java.io.Serializable;

@SuppressWarnings("all")
public class Activity implements Serializable{
  public String name;

  public void cg_init_Activity_1(final String nm) {

    name = nm;
  }

  public Activity(final String nm) {

    cg_init_Activity_1(nm);
  }

  public Activity() {}

  public String toString() {

    return "Activity{" + "name := " + Utils.toString(name) + "}";
  }
}
