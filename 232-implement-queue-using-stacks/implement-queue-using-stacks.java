class MyQueue {
    Stack<Integer> data;
    Stack<Integer> aux;

    public MyQueue() {
        data = new Stack<>();
        aux = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
    }
    
    public int pop() {
        if (empty()) return 0;
        if (aux.empty()) shiftData();
        return aux.pop();
    }
    
    public int peek() {
        if (empty()) return 0;
        if (aux.empty()) shiftData();
        return aux.peek();
    }
    
    public boolean empty() {
        return data.isEmpty() && aux.empty();
    }

    private void shiftData() {
        while (!data.empty()) aux.push(data.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */