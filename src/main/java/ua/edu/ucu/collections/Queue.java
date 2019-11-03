package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    public Queue(Object[] objs) {
        queue = new ImmutableLinkedList(objs);
    }

    public Object peek() { return queue.getFirst(); }

    public Object dequeue()
    {
        Object first = queue.getFirst();
        queue = queue.removeFirst();
        return first;
    }

    public void enqueue(Object e)
    {
        queue = queue.addLast(e);
    }

}
