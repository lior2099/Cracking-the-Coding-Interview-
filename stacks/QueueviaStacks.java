package stacks;

import java.util.Stack;

public class QueueviaStacks<T> {
    /*
        Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks
     */
    Stack<T> newStack;
    Stack<T> oldStack;

    public QueueviaStacks(){
        newStack = new Stack<>();
        oldStack = new Stack<>();
    }

    public int size(){
        return newStack.size() + oldStack.size();
    }

    public void add(T data){
        newStack.push(data);
    }

    private void moveStacks(){
        if (oldStack.isEmpty()){
            while (!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
    }

    public T peek(){
        moveStacks();
        return oldStack.peek();
    }

    public T remove(){
        moveStacks();
        return oldStack.pop();
    }

}
