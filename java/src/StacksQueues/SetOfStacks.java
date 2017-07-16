package StacksQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by gerardo on 16/07/17.
 */
public class SetOfStacks {

    ArrayList<Integer> sizes = null;
    ArrayList<Stack<Integer>> subStacks = null;
    int MAX_CAP = 0;

    SetOfStacks(int maxSize) {
        MAX_CAP = maxSize;
        sizes = new ArrayList<Integer>();
        subStacks = new ArrayList<Stack<Integer>>();
    }

    public void push(int val) {
        boolean inserted = false;

        for(int i=0; i< sizes.size(); i++) {
            if (sizes.get(i) < MAX_CAP) {
                subStacks.get(i).push(val);
                sizes.set(i, sizes.get(i) + 1);
                inserted = true;
                break;
            }
        }

        if(!inserted) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(val);
            subStacks.add(s);
            sizes.add(1);
        }

    }

    public int popAt(int index) {
        Stack s = subStacks.get(index);
        int val = (int) s.pop();
        sizes.set(index,sizes.get(index) - 1);
        return val;
    }

}
