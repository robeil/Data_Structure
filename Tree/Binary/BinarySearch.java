package Data_Structure.Tree.Binary;

import DemoCodeU.w4l7.w3l6.SearchTree;

public class BinarySearch<E extends Comparable<E>> implements SearchTree<E> {

    public Node<E> root;
    protected boolean inserted;
    protected boolean itemRemoved;


    public static class Node<E>{
        public Node<E> left;
        public Node<E> right;
        public E data;
        //todo inner class constructor
        public Node(E item){
            this.data = item;
            this.left = null;
            this.right = null;
        }
    }

    //todo outer class constructor
    public BinarySearch(){
        this.root = null;

    }
    //todo add method
    private Node<E> add(Node<E> root, E item){
       if(root == null){
           inserted = true;
           return new Node<>(item);
       } else if(item.compareTo(root.data) == 0){
           inserted = false;
          return root;
       } else if(item.compareTo(root.data) < 0){
           root.left = add(root.left, item);
           return root;
       } else {
           root.right = add(root.right, item);
           return root;
       }
    }
    //todo override add method
    @Override
    public boolean add(E item) {
       root = add(root, item);
       return inserted;
    }
    //todo find method
    private E find(Node<E> root, E target){
        if(root == null){
            return null;
        }
        //todo comparing the target to the root
        int comp = target.compareTo(root.data);
      if(comp == 0){
          return root.data;
      } else if(comp < 0) {
       root.left.data = find(root.left, target);
       return root.left.data;
      } else{
          root.right.data = find(root.right, target);
          return root.right.data;
      }

    }
    //todo override find method
    @Override
    public E find(E target) {
       root.data = find(root, target);
       return root.data;
    }
    //todo contains override method
    @Override
    public boolean contains(E target) {
        return find(target) != null;  ///todo ???????????
    }
    //todo get root
    public E getRoot(){
        return (E) root.toString();
    }
    //todo delete method
    public E delete(Node<E> root, E target){
        if(root == null){
            return null;
        }
        return null;
    }
    @Override
    public E delete(E target) {
        return null;
    }

    @Override
    public boolean remove(E target) {
        return  delete(target) != null; ///todo ???????????
    }

    public void printInorder(Node<E> root){
        if(root == null){
            return;
        } else{
            printInorder(root.left);
            System.out.println(root.data + " ");
            printInorder(root.right);
        }
    }
//todo print greater than 50
    private int printGreater(Node<E> root){
        if(root == null){
            return 0;
        }
        int greaterItem = 0;
        if((Integer)root.data > 50){
            return 1 + printGreater(root.left) + printGreater(root.right);
        } else{
            greaterItem =  printGreater(root);
            return greaterItem;
        }
    }
    //todo greater than  50
    public int printGreater(){
        return printGreater(root);
    }


//    public static void main(String[] args) {
//        BinarySearch bi = new BinarySearch();
//       // List<Integer> list = Ararys {56,46,36,66,50, 32,60, 70, 55, 59,72,69};
//       // {56,46,36,66,50, 32,60, 70, 55, 59,72,69}
//
//    }
}
