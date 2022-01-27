package Data_Structure.Queue;

import java.util.NoSuchElementException;

public class QueueLinkedList<E> implements QueueInterface<E> {
  private Node<E> head = null;
  private Node<E> tail = null;
  private  int size = 0;

  private static class Node<E> {
      private Node<E> next;
      private E data;

      private Node(E item) {
          this.data = item;
          this.next = null;
      }

      private Node(Node<E> next, E item) {
          this.data = item;
          this.next = next;
      }
  }
  private boolean add(Node<E> next, E item){
      Node<E> newNode = new Node<>(item);
      if(head == null){
          head = newNode;
          tail = head;
      } else {
          tail.next = newNode;
          tail = tail.next;
      }
      size++;
      return true;
  }

    @Override
    public boolean offer(E item) {
        Node<E> newNode = new Node<>(item);
        if(head == null){
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    return true;
    }

    @Override
    public E remove() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E toRemoveItem = head.data;
        head = head.next;
        size--;
        return toRemoveItem;
    }

    @Override
    public E poll() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E toRemoveItem = head.data;
        head = head.next;
        size--;
        return null;
    }

    @Override
    public E peek() {
      if(size == 0) {
          return null;
      }
        return head.data;
    }

    @Override
    public E element_1() {
        if(head == null)
            throw new NoSuchElementException();
        return head.data;
    }

    public int getSize_1(){
      return size;
    }
}
