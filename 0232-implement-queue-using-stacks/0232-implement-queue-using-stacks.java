import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    // O(1) time
    public void push(int x) {
        inStack.push(x);
    }

    // Amortized O(1) time
    public int pop() {
        shiftStacks();
        return outStack.pop();
    }

    // Amortized O(1) time
    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Only transfer elements when outStack is completely drained
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}