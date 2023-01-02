import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Lexical_Analyzer {
    FileReader file_reader = new FileReader("code.txt");
    BufferedReader br = new BufferedReader(file_reader);

    LinkedList<Token> Token_list = new LinkedList<>();


    public Lexical_Analyzer() throws IOException {

       char c = ((char) br.read());

       while(c!=-1)
       {

           if(isOperator(c))
           {
              Token_list.add(new Token(Token_Category.Operator,c+""));
           }
           else if(Character.isDigit(c))
           {

              Token_list.add(new Token(Token_Category.Constant,c+""));
           }
           else if(c==';')
           {

              Token_list.add(new Token(Token_Category.Keyword,c+""));
           }
           else
           {
               Token_list.add(new Token(Token_Category.Identifier,c+""));

           }
       }

    }

    public boolean isOperator(char c)
    {
        char[] Operators = {'+', '-' , '*' , '/' , '='};
        for (int i=0 ;i<Operators.length;i++)
        {
            if(c==Operators[i])
            {
                return true;
            }
        }
        return false;
    }

}
