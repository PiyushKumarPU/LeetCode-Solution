class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                // calculate and push back to stack
                int first = stack.pop();
                int second = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = second - first;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = second / first;
                        break;
                    default:
                        result = 0;
                        break;
                }
                stack.push(result);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}