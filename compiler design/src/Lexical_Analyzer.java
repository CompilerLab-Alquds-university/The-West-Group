import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Lexical_Analyzer {
    FileReader file_reader = new FileReader("code.txt");
    BufferedReader br = new BufferedReader(file_reader);

    LinkedList<Token> Token_list = new LinkedList<>();

    public LinkedList<Token> getToken_list() {
        return Token_list;
    }

    public void setToken_list(LinkedList<Token> token_list) {
        Token_list = token_list;
    }

    public Lexical_Analyzer() throws IOException {

       int a;

       while((a=br.read())!=-1)
       {
           char c =(char) a;

           if(a!=127 && a!=32 && a!=10 && a!=13) {


               if (isOperator(c)) {
                   Token_list.add(new Token(Token_Category.Operator, c + ""));
               } else if (Character.isDigit(c)) {

                   if(Token_list.isEmpty())
                   {
                       Token_list.add(new Token(Token_Category.Constant, c + ""));
                       continue;
                   }

                   Token Temp_Token = Token_list.getLast();

                   if (Temp_Token.tokenCategory==Token_Category.Constant)
                   {
                       Temp_Token.value = Temp_Token.value + c;
                   }
                   else
                   {
                       Token_list.add(new Token(Token_Category.Constant, c + ""));
                   }

               } else if (c == ';') {

                   Token_list.add(new Token(Token_Category.Keyword, c + ""));
               } else {
                   Token_list.add(new Token(Token_Category.Identifier, c + ""));

               }
           }
       }


        //for (Token token : Token_list) System.out.println(token.value);

    }

    public boolean isOperator(char c)
    {
        char[] Operators = {'+', '-' , '*' , '/' , '='};
        for (char operator : Operators) {
            if (c == operator) {
                return true;
            }
        }
        return false;
    }


}