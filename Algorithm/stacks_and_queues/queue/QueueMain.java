package Algorithm.stacks_and_queues.queue;

public class QueueMain {
    static void main() throws Exception {
        CustomQueue queue = new CustomQueue();

        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(10);

        queue.display();

        System.out.println(queue.remove());

        queue.display();
    }
}
