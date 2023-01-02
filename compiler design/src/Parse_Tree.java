import java.util.LinkedList;

public class Parse_Tree {
    private LinkedList<Token> tokens;

    public Parse_Tree(LinkedList<Token> tokens) {
        this.tokens = tokens;

    }
    int flag=0;

    Token token;
    public void Parse() {

        for (Token token : tokens){


        if((token.tokenCategory.equals(Token_Category.Constant))||(token.tokenCategory.equals(Token_Category.Identifier)))
        {
            flag++;

        } else if (token.tokenCategory.equals(Token_Category.Operator)) {

            flag--;
        }
        if (flag>1||flag<0)
        {
            throw new RuntimeException("Syntax error");
        }
    }
    }

}
