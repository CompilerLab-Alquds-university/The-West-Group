import java.util.LinkedList;

public class Semantic_Analyzer {
    LinkedList<Token> tokens;
    LinkedList<Node> NodeList;

    public Node getRoot() {
        return root;
    }

    Node root;
    int index=-999;
    public Semantic_Analyzer(LinkedList<Token> list) {
        this.tokens = list;
        NodeList = new LinkedList<>();
    }

    public void AST() {
    for(Token token:tokens)
    {
        if(token.value!="="){
        NodeList.add(new Node(token.value,null,null,token.tokenCategory));
        }
    }

    while (NodeList.size()>1)
    {
        Priority(NodeList);

        NodeList.get(index).setFlag(true);

        NodeList.get(index).setRight(NodeList.remove(index+1));
        NodeList.get(index).setLeft(NodeList.remove(index-1));
        index-=2;


    }

    if (NodeList.size()==1)
    {
        root=NodeList.get(0);
    }

        //System.out.println(root.value);

    }

    public void Priority(LinkedList<Node> nodeList)
    {
        for (int i=0; i<nodeList.size();i++)
        {
            if(!nodeList.get(i).flag){

            if(nodeList.get(i).value.equals("*") || nodeList.get(i).value.equals("/")) {
                index=i;
                break;
            }
            else if(nodeList.get(i).value.equals("-") || nodeList.get(i).value.equals("+")){
                index=i;
            }
            }
        }

    }

}
