package Data_Structure.DS_assignment9;

public class BinaryTree<E> implements Comparable<E>{

    private Node<E> root;
    private int size = 0;

    //todo creating inner class node
    private static class Node<E>{
        //todo instances field
        private Node<E> left;
        private Node<E> right;
        private E data;

        //todo constructor for node
        private Node(E item){
            this.data = item;
            this.left = null;
            this.right = null;
        }

    }
    //todo constructor for the BinaryTree class
    public BinaryTree(){
        root = null;

    }
    //todo insert method
    public Node<E> insert(Node<E> root, E item){
        boolean isItAdded = false;
        if(root == null){
            root = new Node<E>(item);
            size++;
            isItAdded =  true;
        }
        if(root.data == item){
            isItAdded = false;
        }
        if((int)root.data > (int)item){
            root.left = insert(root.left, item);
            size++;
        }
        if((int)root.data < (int)item){
            root.right = insert(root.right, item);
            size++;
        }
        return root;
    }
    //todo insert to the tree
    public void insertToTree(E item){
        root = insert(root, item);
    }
    //todo inorder
    public void inOrder(Node<E> root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
    //todo preorder
    public void preOrder(Node<E> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    //todo preorder
    public void preOrder(Node<E> root, Node<E> child){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    //todo postorder
    public void postOrder(Node<E> root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    // todo Pre-order traversal
    public void preOrderTraversal(){
        preOrder(root);
    }
    // todo In-order traversal
    public void inOrderTraversal(){
      inOrder(root);
    }
    // todo Post-order traversal
    public void postOrderTraversal(){
        postOrder(root);
    }
    //todo compare method
    @Override
    public int compareTo(E o) {
        return 0;
    }
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree<>();
        //myTree = new int[55,45,47,43,54,58,76,71,50,60,68,80,91];
        myTree.insertToTree(55);
        myTree.insertToTree(45);
        myTree.insertToTree(47);
        myTree.insertToTree(43);
        myTree.insertToTree(54);
        myTree.insertToTree(58);
        myTree.insertToTree(76);
        myTree.insertToTree(71);
        myTree.insertToTree(50);
        myTree.insertToTree(60);
        myTree.insertToTree(68);
        myTree.insertToTree(80);
        myTree.insertToTree(91);

        System.out.println("Preorder to traversal of binary search tree");
        myTree.preOrderTraversal();
        System.out.println("\nInorder to traversal of binary search tree");
        myTree.inOrderTraversal();
        System.out.println("\nPostorder to traversal of binary search tree");
        myTree.postOrderTraversal();


        /*todo ---> after removing 47 the successor will become 54
         todo --->  after removing 76 the succesor will be become 80

        todo after removing 50 and 68
                                        55
                                        /\
                                       /  \
                                      45   58
                                    /  \     \
                                   /     \     \
                                 43      47   76
                                        /     / \
                                       /     /   \
                                     54    71     80
                                        /          \
                                       /            \
                                     60             91

         todo after removing 47 and 80 the tree will look the same but minus two leaf(external nodes)
                                        55
                                        /\
                                       /  \
                                      45   58
                                    /  \     \
                                   /     \     \
                                 43      54   76
                                             / \
                                            /   \
                                         71      91
                                        /
                                       /
                                     60

            todo The draw after removing 47 and 80
                                        55
                                        /\
                                       /  \
                                     54   58
                                     /      \
                                   /          \
                                43            91
                                             /
                                            /
                                         71
                                        /
                                       /
                                      60

         */
    }
}
