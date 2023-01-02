import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Lexical_Analyzer {
    FileReader file_reader = new FileReader("code.txt");
    BufferedReader br = new BufferedReader(file_reader);

    LinkedList<Token> Token_list = new LinkedList<>();


    public Lexical_Analyzer() throws IOException {

       int a;

       while((a=br.read())!=-1)
       {
           char c =(char) a;

           if(a!=127 && a!=32 && a!=10 && a!=13) {


               if (isOperator(c)) {
                   Token_list.add(new Token(Token_Category.Operator, c + ""));
               } else if (Character.isDigit(c)) {

                   Token_list.add(new Token(Token_Category.Constant, c + ""));
               } else if (c == ';') {

                   Token_list.add(new Token(Token_Category.Keyword, c + ""));
               } else {
                   Token_list.add(new Token(Token_Category.Identifier, c + ""));

               }
           }
       }


       for (int i=0; i<Token_list.size();i++)
        System.out.println(Token_list.get(i).value);

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
