package stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Objects;

public class StackofPlates {
    /*
        Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
        Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
        threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
        composed of several stacks and should create a new stack once the previous one exceeds capacity.
        SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
        (that is, pop () should return the same values as it would if there were just a single stack).
        FOLLOW UP
        Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.
     */

    private ArrayList<FixedStack<Objects>> stacks;
    private int capacity = 0;

    public StackofPlates(int capacity){
        this.capacity = capacity;
        stacks = new ArrayList<>();
    }

    public void push(Objects data){
        FixedStack<Objects> lest = getLestStack();

        if (lest == null || lest.size() == capacity){
            FixedStack<Objects> stack = new FixedStack<>(capacity);
            stack.push(data);
            stacks.add(stack);
        }
    }

    public Objects pop(){
        FixedStack<Objects> lest = getLestStack();
        if (lest == null){
            throw new EmptyStackException();
        }
        Objects toSend = lest.pop();
        if (lest.isEmpty()){
            stacks.remove(stacks.size() - 1);
        }

        return toSend;
    }

    public Objects popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        FixedStack<Objects> stack = stacks.get(index);

        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        Objects data = stack.pop();


        if (stack.isEmpty()) {
            stacks.remove(index);
        }

        return data;
    }

    public boolean isEmpty(){
        FixedStack<Objects> lest = getLestStack();

        return  lest == null || lest.isEmpty();
    }

    private FixedStack<Objects> getLestStack(){
        if (stacks.isEmpty()){
            return null;
        } else {
            return stacks.get(stacks.size() - 1);
        }
    }



}
