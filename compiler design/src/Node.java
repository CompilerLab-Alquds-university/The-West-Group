import java.util.LinkedList;

public class Node {

    String value;
    Node left;
    Node right;

    Token_Category category;

    public Token_Category getCategory() {
        return category;
    }

    public void setCategory(Token_Category category) {
        this.category = category;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    Boolean flag = false;

    public Node(String value, Node left, Node right, Token_Category category) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
