package Algorithm.stacks_and_queues.stack;

public class Main {
    static void main() throws Exception {
        CustomStack customStack = new CustomStack(10);

        customStack.push(10);
        customStack.push(2);
        customStack.push(2000);
        customStack.push(4);
        customStack.push(1000);
        customStack.push(300);

        System.out.println(customStack.min());
        System.out.println(customStack.pop());
        System.out.println(customStack.peak());


    }
}
