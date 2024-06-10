class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
    
        Deque<Integer> stack = new ArrayDeque<>();
        Map<String, BiFunction<Integer, Integer, Integer>> operations = Map.of(
            "+", (a, b) -> b + a,
            "-", (a, b) -> b - a,
            "*", (a, b) -> b * a,
            "/", (a, b) -> b / a
        );
        
        for (String token : tokens) {
            if (operations.containsKey(token)) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(operations.get(token).apply(first, second));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}