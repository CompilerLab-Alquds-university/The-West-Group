import java.util.LinkedList;

public class Parse_Tree {
    private LinkedList<Token> tokens;
    private int current = 0;

    public Parse_Tree(LinkedList<Token> tokens) {
        this.tokens = tokens;

    }
    int flag=0;
    int TrueFlag=0;

    Token token;
    public void Parse() {

        token = tokens.get(current);

        switch (token.tokenCategory) {
            case Constant,Keyword,Operator -> {
                    throw new RuntimeException("syntax error");
            }
            case Identifier ->
            {
                match(Token_Category.Identifier);
                match(Token_Category.Operator);
                match(Token_Category.Constant);
                match(Token_Category.Keyword);
                if(flag>0)
                {
                    current-=TrueFlag;
                    flag=0;
                    TrueFlag=0;
                }
                else{
                    return;
                }
                match(Token_Category.Identifier);
                match(Token_Category.Operator);
                match(Token_Category.Constant);
                match(Token_Category.Operator);
                match(Token_Category.Constant);
                match(Token_Category.Keyword);
                if(flag>0)
                {
                    current-=TrueFlag;
                    flag=0;
                    TrueFlag=0;

                }
                else{
                    return;
                }
                match(Token_Category.Identifier);
                match(Token_Category.Operator);
                match(Token_Category.Identifier);
                match(Token_Category.Operator);
                match(Token_Category.Constant);
                match(Token_Category.Keyword);
                if (flag>0)
                {
                    throw new RuntimeException("syntax error");
                }

            }
        }
    }

    private void match(Token_Category category) {
        Token Temp_Token = tokens.get(current);
        if (Temp_Token.tokenCategory.equals(category))
        {
            current++;
            TrueFlag++;
        }
        else {
           flag++;
        }
    }

}
