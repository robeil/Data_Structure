package Data_Structure.Queue;

public interface QueueInterface<E> {
    public boolean offer(E item);
    public E remove();
    public E poll();
    public E peek();
    public E element_1();

}
