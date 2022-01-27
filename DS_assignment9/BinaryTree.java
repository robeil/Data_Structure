package Data_Structure.DS_assignment9;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;
    protected boolean isItAdded = false;
    protected E isItRemoved;
    protected int size = 0;


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
    private Node<E> insert(Node<E> root, E item){

        if(root == null){
            root = new Node<E>(item);
            isItAdded =  true;
            size++;
        }
        if(root.data == item){
            isItAdded = false;
            return root;
        }
        int comResult = root.data.compareTo(item);
        if(comResult > 0){
            root.left = insert(root.left, item);
            size++;
        }
        if(comResult < 0){
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
    private void inOrder(Node<E> root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
    //todo preorder
    private void preOrder(Node<E> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    //todo preorder
    private void preOrder(Node<E> root, Node<E> child){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    //todo postorder
    private void postOrder(Node<E> root){
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

    //todo search method
    private E search(Node<E> root, E item){
       if(root == null){
            return null;
        }
           int comResult = item.compareTo(root.data);
           if (comResult == 0) {
               return root.data;
           } else if (comResult < 0) {
               return search(root.left, item);
           } else {
               return search(root.right, item);
           }
    }
    //todo search m node from the element
    public E searchItem(E item){ //fixme ???????
        return search(root, item);
    }
    //todo delete method
    private Node<E> delete(Node<E> root, E itemToRemove){
        if(root == null){
            return root;
        }
        int comp = itemToRemove.compareTo(root.data);
        if(comp < 0){
            root.left = delete(root.left, itemToRemove);
            return root.left;
        } else if(comp > 0){
            root.right = delete(root.right, itemToRemove);
            return root.right;
        } else {
            isItRemoved = root.data;
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.left.right == null) {
                    root.data = root.left.data;
                    root.left = root.left.left;
                    return root;
                } else {
                    root.data = findPredessor(root.left);
                    return root;
                }
            }
        }
    }
    //todo delete method
    public Node<E> delete(E itemToRemove){
        return delete(root, itemToRemove);
    }
    //todo find predessor method
    private E findPredessor(Node<E> parent){
        if(parent.right.right == null){
            E returnValue = parent.data;
            parent.right = parent.left;
            return returnValue;
        } else {
            return findPredessor(parent.right);
        }
    }
    //todo size method that count all the count
    public int size(Node<E> root){
        if(root == null){
            return 0;
        }
        int totalNode = 1 + size(root.left) + size(root.right);
        return totalNode;
    }
    //todo size method
    public int size(){
        return size(root);
    }
    // todo main method
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
        System.out.println("\nFound it : " + myTree.searchItem(91));
        System.out.println("Is it deleted : " + myTree.delete(91));
        System.out.println("Total number of nodes : " + myTree.size());

        /*todo ---> after removing 47 the successor will become 50
         todo --->  after removing 76 the successor will be become 80

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
