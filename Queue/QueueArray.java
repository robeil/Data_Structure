package Data_Structure.Queue;

import java.util.NoSuchElementException;

public class QueueArray<E> implements QueueInterface<E>{

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private static final int INITIAL_CAPACITY = 10;
    private E[] data;

    public QueueArray(int capacity){
        this.capacity = capacity;
        data =(E[]) new Object[this.capacity];
        rear = capacity -1;
        front = 0;
        size = 0;
    }
    public QueueArray(){
       this(INITIAL_CAPACITY);
    }
   private void reallocate(){
        int newCapacity = capacity * 2;
        E[] newData = (E[]) new Object[newCapacity];
       int j = front;
       for(int i = 0; i < size; i++){
           newData[i] = data[j];
           j = (j + 1)  % capacity;
           data = newData;
       }
    }
    public boolean add(E item){
        if(size == capacity){
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        data[rear] = item;
        return true;
    }
    @Override
    public boolean offer(E item) {
        if(size == capacity){
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        data[rear] = item;
        return true;
    }

    @Override
    public E remove() {
        if(size == 0)
            throw new NoSuchElementException();
        E hand = data[size];
        front = (front + 1) % capacity;
        size--;
        return hand;
    }

    @Override
    public E poll() {
        if(size == 0)
            return null;
        E hand = data[front];
        front = (front + 1) % capacity;
        size--;
        return hand;
    }

    @Override
    public E peek() {
        if(size == 0)
           return null;
        return data[front];
    }

    @Override
    public E element_1() {
        if(size == 0)
            throw new NoSuchElementException();
        return data[front];
    }
}
