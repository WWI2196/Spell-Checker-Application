public class Node{
    char data;
    Node[] children;
    boolean isEnd;

    public Node(){
        children = new Node[26];
        isEnd = false;
    }

    public Node(char data){
        this.data = data;
        children = new Node[26];
        isEnd = false;
    }
    
    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Node getChild(char c){
        return children[c - 'a'];
    }

    public boolean hasChild(char c){
        if (c < 'a' || c > 'z') {
            throw new IllegalArgumentException("Invalid character"+ c);
        }
        return children[c - 'a'] != null;
    }

     public void addChild(char c, Node node) {
         children[c - 'a'] = node;
     }
}