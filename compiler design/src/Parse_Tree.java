import java.util.LinkedList;

public class Parse_Tree {
    private LinkedList<Token> tokens;
    private int current = 0;

    public Parse_Tree(LinkedList<Token> tokens) {
        this.tokens = tokens;
    }

    public Node Parse() {
        Node root = new Node();
        while (current < tokens.size()) {
            root.addChild(expression());
        }
        return root;
    }
    private Node expression() {

        Token token = tokens.get(current);

        switch (token.tokenCategory)
        {
            case Constant-> {
                current++;
                return new Node(token);
            }
            case Identifier-> {
                current++;
                Node node = expression();

                if((!";".equals(token.value))||(token.tokenCategory!=Token_Category.Operator))
                {
                    throw new RuntimeException("Use variable correctly");
                }
                return node;
            }

            case Operator -> {
            }
            default -> throw new RuntimeException("Unexpected token: " + token.getValue());
        }
        return null;
    }
}

