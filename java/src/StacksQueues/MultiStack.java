package StacksQueues;

/**
 * Created by gerardo on 16/07/17.
 */
public class MultiStack {

    private int [] sizes = null;
    private int [] values = null;
    private int capacity = 0;
    private int stackNum = 0;

    // Init
    MultiStack(int numStacks, int size) {
        this.sizes = new int [numStacks];
        this.values = new int[numStacks * size];
        this.capacity = size;
        this.stackNum = numStacks;
    }

    public void push(int stackN, int val) {
        this.sizes[stackN]++;
        this.values[indexOfTop(stackN)] = val;
    }

    public int pop(int stackN) {
        int val = this.values[this.indexOfTop(stackN)];
        this.sizes[stackN]--;
        return val;
    }

    private int indexOfTop(int stackN) {
        return (this.capacity * (stackN + 1)) - this.sizes[stackN];
    }

}
