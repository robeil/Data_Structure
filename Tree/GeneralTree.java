package Data_Structure.Tree;

import java.util.List;

public class GeneralTree<E> {
    private Node<E> root;
    private int size = 0;

    private static class Node<E>{

        private E data;
        private List<Node> children;
        private Node<E> parent;

        private Node(E item){
            this.data = item;
        }

    }

    public static void main(String[] args) {
        GeneralTree<String> list = new GeneralTree<>();

    }
}
