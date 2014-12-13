/**
 * 
 * @author Raymond
 *
 */
package org.uiowa.cs2820.engine;

//Iterator pattern requires that this implements the Handler
public class IdentifierRepository implements Handler{
	//examples of identifiers
	public String ids[] = {"R","S","T","U","V"};
	
	public Iterator getIterator() {
		return new IdIterator();
	}
	
	private class IdIterator implements Iterator {
		private int pos = 0;

		public boolean hasNext() {
			if (pos < ids.length){
				return true;
			}
			return false;
		}

		public Object next() {
			if (this.hasNext()){
				return  ids[pos++];
			}
			return null;
		} 
		
	}

	
}
