class Solution {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '(' || current == '[') characterStack.push(current);
            else {
                if(characterStack.isEmpty()) return false;
                char stackChar = characterStack.peek();
                if (current == '}') {
                    if (stackChar != '{')
                        return false;
                    characterStack.pop();
                } else if (current == ']') {
                    if (stackChar != '[')
                        return false;
                    characterStack.pop();
                } else if (current == ')') {
                    if (stackChar != '(')
                        return false;
                    characterStack.pop();
                }
            }
        }
        return characterStack.isEmpty();
    }
}