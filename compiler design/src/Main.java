import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

       Lexical_Analyzer analyzer = new Lexical_Analyzer();
       Parse_Tree parseTree = new Parse_Tree(analyzer.getToken_list());
       parseTree.Parse();

       Semantic_Analyzer semanticAnalyzer = new Semantic_Analyzer(analyzer.getToken_list());
       semanticAnalyzer.AST();

       Code_Generator generator = new Code_Generator(semanticAnalyzer.getRoot());
       generator.printPostorder();


    }

}

