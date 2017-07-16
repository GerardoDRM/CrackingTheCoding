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
}
