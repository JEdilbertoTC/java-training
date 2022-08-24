package List;

import java.util.Iterator;

public interface List<T> {
    boolean add(T element);

    boolean remove(int index);

    T getAt(int index);

    void setAt(int index, T element);

    boolean contains(T element);

    int size();

    Iterator<T> iterator();
}