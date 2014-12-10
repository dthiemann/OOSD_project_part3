/**
 * 
 * @author Raymond
 *
 */
package org.uiowa.cs2820.engine;

import java.util.*;

//Iterator pattern requires that this implements the Handler
public class IdentifierRepository implements Handler{

	public String ids[] ={}; //function that gets all the ids in array list
	//need something to fill in this blank
	
	@Override
	public Iterator getIterator() {
		return new IdIterator();
	}
	
	private class IdIterator implements Iterator {
		int index;

		@Override
		public boolean hasNext() {
			if (index < ids.length){
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()){
				return  ids[index++];
			}
			return null;
		} 
		
	}

	
}
