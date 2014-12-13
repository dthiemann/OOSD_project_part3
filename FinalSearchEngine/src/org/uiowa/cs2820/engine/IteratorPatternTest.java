package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class IteratorPatternTest {

	@Test //test that iterator goes through all the values
	public void test() {
		String here = null; 
		IdentifierRepository id = new IdentifierRepository();
		for(Iterator iter = id.getIterator(); iter.hasNext();){
	         String name = (String)iter.next();
	         System.out.println("Name : " + name);
	         here = name;
	}	
		//the last identifier is V so the last value of here should be V
		assertEquals(here,"V");
}
}
