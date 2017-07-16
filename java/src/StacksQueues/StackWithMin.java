package StacksQueues;

import java.util.Stack;

/**
 * Created by gerardo on 16/07/17.
 */
public class StackWithMin extends Stack<Integer> {
    private int minVal = Integer.MAX_VALUE;

    public void push(int val) {
        if (minVal > val)
            minVal = val;

        super.push(val);
    }

    public Integer pop() {
        int val = super.pop();
        if (super.peek() < minVal)
            minVal = super.peek();

        return val;
    }

    public int showMin() {
        return minVal;
    }
}
