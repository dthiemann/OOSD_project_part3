public class GreaterThan {
	class SearchGreaterThan implements Traverser {
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
			    }
	}
}
