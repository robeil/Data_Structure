package Data_Structure.Tree;

public class MyBinaryTree<E> {
    private Node<E> root;
    private int size = 0;

    //todo inner class node
    private static class Node<E>{
        private Node<E> left;
        private Node<E> right;
        private E data;

        //todo constructor
        private Node(E item){
            this.data = item;
            this.left = null;
            this.right = null;
        }
    }
    //todo inset method
    public Node<E> insert(Node<E> root, E item){
        if(root == null){
            root = new Node<>(item);
            size++;
        }
        if((int)root.data > (int)item){
            root.left = insert(root.left,item);
            size++;
        }
        if((int)root.data < (int)item){
            root.right = insert(root.right, item);
        }
        return root;
    }
    //todo in-order method
    public void inOrder(Node<E> root){
        if(root == null){
            return;
        }
        inOrder(root);
        System.out.println(root.data + " ");
        inOrder(root);
    }
    //todo pre-order method
    public void preOrder(Node<E> root){
        if(root == null){
            return;
        }
        preOrder(root);
        System.out.println(root.data + " ");
        preOrder(root);
    }
    //todo post-order method
    public void postOrder(Node<E> root){
        if(root == null){
            return;
        }
        postOrder(root);
        System.out.println(root.data + " ");
        postOrder(root);
    }
    //todo in-order traversal
    public void inOrderTraversal(){
        inOrder(root);
    }
    //todo pre-order traversal
    public void preOrderTraversal(){
        preOrder(root);
    }
    //todo post-order traversal
    public void postOrderTraversal(){
        postOrder(root);
    }
    //todo toString method
    public String toString(){
        return (String) root.data;
    }

}
