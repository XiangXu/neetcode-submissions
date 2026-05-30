class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char curr : s.toCharArray()) {
            if(curr == '(') {
                stack.push(')');
            }
            else if(curr == '{') {
                stack.push('}');
            }
            else  if(curr == '[') {
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || stack.pop() != curr) {
                    return false;
                } 
            }
        }
        return stack.isEmpty();
    }
}
