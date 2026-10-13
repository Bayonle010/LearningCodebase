package Algorithm.stacks_and_queues;


import java.util.Stack;

// implementation to make remove have O(1)
public class QueueUsingStackR1 {
    private Stack<Integer> first;
    private Stack<Integer> second;


    public QueueUsingStackR1(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item){
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(item);

        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int remove(){
       return first.pop();
    }

    public int peek(){
        return first.peek();
    }


}

