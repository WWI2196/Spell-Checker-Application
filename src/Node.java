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

    public Node getChild(char character){
        return children[character - 'a'];
    }

    public boolean hasChild(char character){
        if (character < 'a' || character > 'z') {
            throw new IllegalArgumentException("Invalid character"+ character);
        }
        return children[character - 'a'] != null;
    }

     public void addChild(char character, Node node) {
         children[character - 'a'] = node;
     }
}