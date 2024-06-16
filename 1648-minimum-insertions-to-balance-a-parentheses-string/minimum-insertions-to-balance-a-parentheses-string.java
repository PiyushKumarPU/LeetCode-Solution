class Solution {
    public int minInsertions(String s) {
        int openCount = 0, operationCount = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == '(') {
                openCount++;
                i++;
            } else {
                int closeCount = 1;
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') closeCount++;
                if (openCount > 0) {
                    operationCount += (closeCount == 2 ? 0 : closeCount);
                    openCount--;
                } else {
                    operationCount += (3 - closeCount);
                }
                i += closeCount;
            }
        }
        if (openCount > 0) {
            operationCount += openCount * 2;
        }
        return operationCount;
    }
}