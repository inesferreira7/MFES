package BrandsAndCelebrities;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Setor {
  public String name;

  public void cg_init_Setor_1(final String nm) {

    name = nm;
  }

  public Setor(final String nm) {

    cg_init_Setor_1(nm);
  }

  public Setor() {}

  public String toString() {

    return "Setor{" + "name := " + Utils.toString(name) + "}";
  }
}
