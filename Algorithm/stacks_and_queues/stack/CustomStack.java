package Algorithm.stacks_and_queues.stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int pointer = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("stack is full already");
            return false;
        }
        pointer++;
        data[pointer] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("cannot pop from an empty stack");
        }
        return data[pointer--];
    }

    public int peak() throws Exception {
        if(isEmpty()){
            throw new Exception("cannot peak from an empty stack");
        }
        return data[pointer];
    }

    public int min() throws Exception {
        if (isEmpty()){
            throw new Exception("min is not present in an empty stack");
        }

        int min = data[0];
        for (int i = 1; i < pointer; i++){
            min = Math.min(min, data[i]);
        }
        return min;
    }


    public boolean  isEmpty(){
        return pointer == -1;
    }
    public boolean isFull(){
        return pointer == data.length - 1;
    }

}
