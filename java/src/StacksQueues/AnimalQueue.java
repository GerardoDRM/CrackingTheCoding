package StacksQueues;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * Created by gerardo on 17/07/17.
 */
public class AnimalQueue {


    LinkedList<AnimalNode> dog = new LinkedList<>();
    LinkedList<AnimalNode> cat = new LinkedList<>();

    public void add(String animal, String name) {
        if(animal.equals("dog")) {
            dog.add(new AnimalNode(name));
        } else {
            cat.add(new AnimalNode(name));
        }
    }

    public void dequeueCat() {
        cat.poll();
    }

    public void dequeueDog() {
        dog.poll();
    }

    public void dequeueAny() {
        if(dog.peek().timestamp.before(cat.peek().timestamp)) {
            dog.poll();
        } else {
            cat.poll();
        }
    }

    public class AnimalNode {
        String animalName = "";
        Timestamp timestamp = null;

        AnimalNode(String name) {
            animalName = name;
            timestamp = new Timestamp(System.currentTimeMillis());
        }

    }
}
