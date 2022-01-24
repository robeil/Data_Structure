package Data_Structure.Tree;

import java.util.Scanner;

public class BinarySearch {
    public static class Tree {
        //todo instance fields
        TreeNode root;
        //todo inner class to create the node
        public class TreeNode{
            //todo instance fields
            int data;
            TreeNode left;
            TreeNode right;
            //todo constructor for the inner class
          public  TreeNode(int data){
              //todo initializing the data
              this.data = data;
              this.left = null;
              this.right = null;
          }
        }
       // todo constructor for the class
        public Tree(){
            root = null;
        }
        //todo insert method
        public TreeNode insert(TreeNode root, int dataToBeInserted){
            if(root == null){
                root = new TreeNode(dataToBeInserted);
                return root;
            }
            if(root.data > dataToBeInserted){
                root.left = insert(root.left, dataToBeInserted);
            }
            if(root.data < dataToBeInserted){
                root.right = insert(root.right, dataToBeInserted);
            }
            return root;
        }
        //todo search method
        public TreeNode search(TreeNode root, int dataToBeSearch){
            if(root == null || root.data == dataToBeSearch){
                return root;
            }
            if(root.data > dataToBeSearch){
                return search(root.left, dataToBeSearch);
            } else {
                return search(root.right, dataToBeSearch);
            }
        }
        //todo indorder
        public void inorder(TreeNode root){
            if(root == null)
                return;

            inorder(root.left);
            System.out.print(root.data +" ");
            inorder(root.right);
        }
        //todo preOrder
        public void preOrder(TreeNode root){
            if(root == null){
                return;
            }
            System.out.print(root.data +" ");
            inorder(root.left);
            inorder(root.right);
        }
        //todo postOrder
        public void postOrder(TreeNode root){
            if(root == null){
                return;
            }
            inorder(root.left);
            inorder(root.right);
            System.out.println(root.data + " ");
        }
        //todo insertIntoTree
        public void  insertIntoTree(int dataToBeInserted){
            root = insert(root, dataToBeInserted);
        }
        //todo searchTree
        public TreeNode searchTree(int dataToBeSearched){
            return search(root, dataToBeSearched);
        }
        //todo inorder Traversal
        public void inOrderTraversal(){
            inorder(root);
        }
        //todo preorder Traversal
        public void preOrderTraversal(){
            preOrder(root);
        }
        //todo postorder
        public void postOrderTraversal(){
            postOrder(root);
        }

          public static void main(String[] args) {
            Tree myTree = new Tree();
            int n , num;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter how many number to be input");
            n = scanner.nextInt();
            System.out.println("Enter " + n + " numbers");
            for(int i = 0; i < n; i++){
                num = scanner.nextInt();
                myTree.insertIntoTree(num);
            }
            System.out.println("Tree insertion done");
            System.out.println("Enter number to be searched");
            n = scanner.nextInt();
            if(myTree.searchTree(n) != null){
                System.out.println("Number found");
            } else {
                System.out.println("Number not found");
            }
            System.out.println("Inorder to traversal of binary search tree");
            myTree.inOrderTraversal();
            System.out.println("\nPreorder to traversal of binary search tree");
            myTree.preOrderTraversal();
            System.out.println("\nPostorder to traversal of binary search tree");
            myTree.postOrderTraversal();
        }

    }
}
