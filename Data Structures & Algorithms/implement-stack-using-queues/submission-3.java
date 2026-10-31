class MyStack {
    private Deque<Integer> d = new ArrayDeque<>();
    public void push(int x) { d.push(x); }
    public int pop()  { return d.pop(); }
    public int top()  { return d.peek(); }
    public boolean empty() { return d.isEmpty(); }
}