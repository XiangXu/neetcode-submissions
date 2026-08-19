class BrowserHistory {

    private Stack<String> frontHistory;
    private Stack<String> backHistory;

    public BrowserHistory(String homepage) {
        frontHistory = new Stack<>();
        backHistory = new Stack<>();
        backHistory.push(homepage);
    }
    
    public void visit(String url) {
        backHistory.push(url);
        frontHistory = new Stack<>();
    }
    
    public String back(int steps) {
        while(steps > 0 && backHistory.size() > 1) {
            frontHistory.push(backHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
    
    public String forward(int steps) {
        while(steps > 0 && !frontHistory.isEmpty()) {
            backHistory.push(frontHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
}