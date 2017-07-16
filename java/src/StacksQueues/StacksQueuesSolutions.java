package StacksQueues;

/**
 * Created by gerardo on 16/07/17.
 */
public class StacksQueuesSolutions {

    // Problem 3.1
    public void createMultiStack() {
        MultiStack m = new MultiStack(3, 2);
        m.push(0, 2);
        m.push(0, 8);
        m.push(1, 9);
        m.push(1, 1);

        System.out.println(m.pop(0));
        System.out.println(m.pop(1));

    }


    // Problem 3.2
    public void searchMin() {
        StackWithMin min = new StackWithMin();
        min.push(2);
        System.out.println(min.showMin());
        min.push(1);
        System.out.println(min.showMin());
    }

    // Problem 3.3
    public void checkSetOfStacks() {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(2);
        setOfStacks.push(1);
        setOfStacks.push(3);

        System.out.println(setOfStacks.popAt(1));
        System.out.println(setOfStacks.popAt(0));
    }

    // Problem 3.4
    public void checkQueue(){
        MyQueue q = new MyQueue();
        q.add(2);
        q.add(8);
        q.add(10);
        q.add(9);

        System.out.println(q.remove());
    }

    // Problem 3.6
}
