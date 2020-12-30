package _10_stack_queue.thuc_hanh.queue_use_linkedlist;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedListQueueClient {
    public static void main(String[] args) {
//        Queue q = new ArrayDeque();

        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}