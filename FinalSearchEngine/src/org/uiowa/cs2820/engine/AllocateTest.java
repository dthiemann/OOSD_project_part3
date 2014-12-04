package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllocateTest {

  @Test
  public void test() {
	CheckPoint.reset();
	for (int i=0; i<100; i++) Allocate.allocate();
	Allocate.free(64);
	assertEquals(Allocate.inquire(2),true);
	assertEquals(Allocate.inquire(64),false);
	assertEquals(Allocate.inquire(83),true);
	}

}
