package Algorithm.stacks_and_queues.stack;

public class LinearTCStackImpl {
    protected int[] data;
    protected int[] minStack;

    private static final int DEFAULT_SIZE = 10;
    private int pointer = -1;
    private int minPointer = -1;

    public LinearTCStackImpl(){
        this(DEFAULT_SIZE);
    }

    public LinearTCStackImpl(int size){
        this.data = new int[size];
        this.minStack = new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("stack is full already");
            return false;
        }

        pointer++;
        data[pointer] = item;

        if (minPointer <= -1 || item <= minStack[minPointer]){
            minPointer++;
            minStack[minPointer] = item;
        }

        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("cannot pop from an empty stack");
        }

        int removed = data[pointer--];

        if (removed == minStack[minPointer]){
            minPointer--;
        }

        return removed;
    }

    public int peek() throws Exception {
        if (isEmpty()){
            throw new Exception("cannot find peek in an empty stack");
        }

        return data[pointer];
    }

    public int min() throws Exception {
        if (isEmpty()){
            throw new Exception("cannot find min in an empty stack");
        }

        return minStack[minPointer];
    }

    public boolean isFull(){
        return pointer == data.length -1;
    }

    public boolean isEmpty(){
        return pointer == -1;
    }
}
