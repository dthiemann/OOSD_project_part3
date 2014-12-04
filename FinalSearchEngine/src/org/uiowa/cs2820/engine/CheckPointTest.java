package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class CheckPointTest {

  @Test
  public void test() {
	CheckPoint.reset();
	// make some object to test with
	// & put some content into the object
	HashMap<String,Integer> K = new HashMap<String,Integer>();
	K.put("Iowa",35);
	K.put("Corn",200);
	CheckPoint.save(K);
	HashMap<String,Integer> R = (HashMap<String,Integer>) CheckPoint.restore();
	assertEquals((int)R.get("Iowa"),35);
    }    

}
