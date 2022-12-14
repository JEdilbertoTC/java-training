package list.arraylist;

import iterator.Iterator;
import list.List;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        size = 0;
        capacity = 20;
        array = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean add(T element) {
        checkIncreaseArray();

        array[size++] = element;
        return true;
    }

    private void checkIncreaseArray() {
        if (capacity == size) {
            capacity += 10;
            array = Arrays.copyOf(array, capacity);
        }
    }

    public boolean remove(int index) {
        checkIndexOutOfBounds(index);

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;

        return true;
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    private void checkIndexOutOfBounds(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds", index));
        }
    }

    public T getAt(int index) {
        checkIndexOutOfBounds(index);

        return array[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
        size = 0;
    }

    public void setAt(int index, T element) {
        checkIndexOutOfBounds(index);

        array[index] = element;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator<>(this);
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new Iterator<>() {
            private int currentIndex = size - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                return array[currentIndex--];
            }
        };
    }

}
