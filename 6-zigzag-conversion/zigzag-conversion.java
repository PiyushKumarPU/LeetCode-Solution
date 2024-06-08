class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int rowIndex = 0;
        boolean goingDown = false;
        
        for (char c : s.toCharArray()) {
            rows[rowIndex].append(c);
            if (rowIndex == 0 || rowIndex == numRows - 1) {
                goingDown = !goingDown;
            }
            rowIndex += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}