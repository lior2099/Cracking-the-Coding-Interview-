package il.co.ilrd.book.stacks;


import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack<T extends Comparable<? super T>> {
    private final Stack<T> minStack;
    private final Stack<T> fullStack;

    public MinStack() {
        this.fullStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(T data) {
        fullStack.push(data);
        if (minStack.empty() || (minStack.peek().compareTo(data) > 0)) {
            minStack.push(data);
        }
    }

    public T pop() {
        if (fullStack.empty()) {
            throw new EmptyStackException();
        }
        T data = fullStack.pop();
        if (data == minStack.peek()) {
            minStack.pop();
        }

        return data;
    }

    public boolean isEmpty(){
        return fullStack.isEmpty();
    }

    public T getMin(){
        if (minStack.empty()){
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public T getData(){
        if (fullStack.empty()) {
            throw new EmptyStackException();
        }
        return fullStack.peek();
    }


    public static void main(String[] args) {
        MinStack<Integer> minStack1 = new MinStack<>();

        minStack1.push(10);
        minStack1.push(6);
        minStack1.push(25);
        minStack1.push(47);
        minStack1.push(3);
        minStack1.push(68);

        System.out.println(minStack1.getMin());
        minStack1.pop();
        minStack1.pop();
        System.out.println(minStack1.getMin());
    }
}
