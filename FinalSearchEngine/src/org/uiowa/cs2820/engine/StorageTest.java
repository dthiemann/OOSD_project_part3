package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class StorageTest {

  @Test
  public void test() {
	DiskSpace.reset();
	CheckPoint.reset();
	Field F = new Field("color","blue");
	Storage.add(F,"first.db");
	Storage.add(F,"second.db");
	Storage.add(F,"third.db");
	F = new Field("color","yellow");
	Storage.add(F,"third.db");
	F = new Field("color","red");
	Storage.add(F,"third.db");
	Storage.remove("third.db");
	}
  }

