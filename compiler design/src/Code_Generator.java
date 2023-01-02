public class Code_Generator {
    Node root;

    public Code_Generator(Node root) {
        this.root = root;
    }

    void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);

        switch (node.category) {
            case Constant, Identifier -> {
                System.out.println("mov eax," + node.value);
                System.out.println("push eax");
            }


            case Operator -> {

                System.out.println("pop eax");
                System.out.println("pop ebx");

                switch (node.value) {

                    case "+": {

                        System.out.println("add eax,ebx");
                        break;

                    }
                    case "-": {

                        System.out.println("sub eax,ebx");
                        break;
                    }
                    case "*": {

                        System.out.println("imul eax,ebx");
                        break;

                    }
                    case "/": {

                        System.out.println("idiv eax,ebx");
                        break;
                    }
                }

                System.out.println("push eax");

            }
        }
      //  System.out.print(node.value + " ");

    }

    void printPostorder() {
        printPostorder(root);
    }


}
