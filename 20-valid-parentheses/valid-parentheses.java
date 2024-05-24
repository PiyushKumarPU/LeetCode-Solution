class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(current == '(' || current == '{' || current == '[') stack.push(current);
            else{
                if(stack.isEmpty()) return false;
                char peek = stack.peek();
                if(
                    (current == ')' && peek == '(') || 
                    (current == '}' && peek == '{') ||
                    (current == ']' && peek == '[')) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}