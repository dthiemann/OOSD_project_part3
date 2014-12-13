public class LessThan {
  class SearchLessThan implements Traverser {
    Field f = null;
    Node h = null;
    ArrayList<Node> less;
    public SearchGreaterThan(Field x){
      f = x;
      less = new ArrayList<Node>();
}
  public boolean process(Item I){
    Node F = (Node) I;
    if (F.Key.islessThan(f)) {
      h = F; // remember this node
      
      return false; // stop traversing;
}
return true;
      }
    }
}
