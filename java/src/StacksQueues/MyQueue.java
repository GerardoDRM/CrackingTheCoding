package StacksQueues;

import java.util.Stack;

/**
 * Created by gerardo on 16/07/17.
 */
public class MyQueue {

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    public void add(int val) {
        s1.push(val);
    }

    public int remove() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return (int) s2.pop();
    }
}
