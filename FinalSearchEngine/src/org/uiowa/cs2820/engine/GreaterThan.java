public class GreaterThan {
	/**class SearchGreaterThan implements Traverser {
		Field f = null;
		Node h = null;
		ArrayList<Node> greater;
		public SearchGreaterThan(Field x){
			f = x;
			greater = new ArrayList<Node>();
		}
		public boolean process(Item I){
			Node F = (Node) I;
		  if (F.Key.isGreaterThan(f)) {
			      h = F; // remember this node
			      return false;  // stop traversing; 
			      }
			    return true;
			    
	}**/
	Field target;
	Database D;
	public GreaterThan(Field f) { 
		D = new LinearDiskDatabase();
		target = f; 
					}
	public String[] find() {
		String [] R = D.fetch(target);
		if (R == null) R = new String[0];
				return R;
					}
		}
	
}
