class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(String operation : operations) {
            if("+".equals(operation)) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            }
            else if("D".equals(operation)){
                int temp = stack.peek();
                stack.push(temp * 2);
            }
            else if("C".equals(operation)) {
                stack.pop();
            }
            else {
                int num = Integer.parseInt(operation);
                stack.push(num);
            }
        }
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}