import java.util.Stack;

public class E_StacksQueues {//232 Implement Que using Stack

	Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    
    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

	

	public static void main(String[] args) {
		E_StacksQueues myQueue = new E_StacksQueues();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		System.out.println(myQueue.pop()+" element"); // return 1, queue is [2]
		myQueue.empty();

	}

}
