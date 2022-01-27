package Data_Structure.Tree.Binary;

public interface SearchInterface<E extends Comparable<E>> {
    boolean add(E item);
    boolean contains(E target);
    E find(E target);
    E delete(E target);
    boolean remove(E target);
}
