import java.util.LinkedList;
import java.util.Queue;

public class E_ImpStQue { //Implement stack using queue //E_StacksQueues- queu using stack

	
	private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public void pop() {
        queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
    
	public static void main(String[] args) {//225 
		

	}

}
