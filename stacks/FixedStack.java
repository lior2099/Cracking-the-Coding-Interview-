package il.co.ilrd.book.stacks;

public class FixedStack<T> {
    private T[] stack;
    private int size;
    private int top;

    public FixedStack(int size) {
        this.stack = (T[]) new Object[size];
        this.top = -1;
        this.size = size;
    }

    public void push(T obj) {
        if (top >= size - 1) {
            throw new IndexOutOfBoundsException("Stack is full. Cannot push element.");
        }
        stack[++top] = obj;
    }

    public T pop() {
        if (top < 0) {
            throw new IndexOutOfBoundsException("Stack is empty. Cannot pop element.");
        }
        return stack[top--];
    }

    public T peek() {
        if (top < 0) {
            throw new IndexOutOfBoundsException("Stack is empty. Cannot peek element.");
        }
        return stack[top];
    }

    public int size() {
        return size;
    }

    public int elements() {
        return top + 1;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
