import java.util.LinkedList;

public class Node {
    private Token token;
    private LinkedList<Node> children;

    public Node() {
    }

    public Node(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public LinkedList<Node> getChildren() {
        return children;
    }
}
