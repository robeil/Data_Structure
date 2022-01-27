package Data_Structure.Tree.HeapTree;

public class HeapTree {

private int[] heap;
private int rear;
private int capacity;

  public HeapTree(int capacity){
      this.capacity  = capacity;
      rear = -1;
      heap = new int[capacity];

  }
  public int size(){
     return rear +1;
  }
  public int getParent(int index){
      return (index - 1 / 2);
  }
  public void swapItem(int first, int second){
      int temp;
      temp = first;
      heap[first] = heap[second];
      heap[second] =  temp;
  }
  //todo insert method
  public void insert(int item){
      if(size() >= capacity){
          return;
      }
      heap[++rear] = item;
      int currentIndex = rear;
      int parentIndex = getParent(currentIndex);
      while(heap[currentIndex] < heap[parentIndex]){
          swapItem(currentIndex, parentIndex);
          currentIndex = parentIndex;
          parentIndex = getParent(currentIndex);

      }
  }
  public void printHeap(){
      for(int i = 0; i < size() / 2; i++){
          System.out.print( "Parent " +heap[i] + " ");
          System.out.print("The left child "  + heap[getLeftChild(i)]+ " " );
          System.out.print("The right child "+ heap[getRightChild(i)] + " ");
          System.out.println();
      }
  }
  public boolean isLeaf(int index){
      return (index >= size() / 2 && index <= size());
    }

    public int getLeftChild(int index){
      return getLeftChild((2 * index) + 1);
    }
    public int getRightChild(int index){
        return getRightChild(index + 2);
    }
  private void heapify(int index){
      if(!isLeaf(index)){
          if(heap[index] > heap[getLeftChild(index)] || heap[index] <heap[getRightChild(index)]){
              if(heap[getLeftChild(index)] < heap[getRightChild(index)]){
                  swapItem(index, getLeftChild(index));
                  heapify(getLeftChild(index));
              } else{
                  swapItem(index, getRightChild(index));
                  heapify(getRightChild(index));
              }
          }
      }
  }
public int remove(){
      int hand = heap[0];
      heap[0] = heap[rear--];
      heapify(0);
      return hand;
}
    public static void main(String[] args) {

      HeapTree heap = new HeapTree(10);
        heap.insert(12);
        heap.insert(24);
        heap.insert(3);
        heap.insert(67);
        heap.insert(89);
        heap.insert(90);
        heap.insert(7);


        heap.printHeap();
    }
}
