public class Stack<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пустой! Нельзя выполнить pop.");
        }
        T element = data[--size];
        data[size] = null;      
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пустой! Нельзя выполнить peek.");
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Увеличение размера массива
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}