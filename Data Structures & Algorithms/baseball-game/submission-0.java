class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String operation : operations) {
            if(operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }
            else if(operation.equals("C")) {
                stack.pop();
            }
            else if(operation.equals("D")) {
                stack.push(stack.peek() * 2);
            }
            else {
                stack.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}