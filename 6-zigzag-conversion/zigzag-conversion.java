class Solution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int start = 0, i = 0;
        while (i < s.length()) {
            if (start == 0) {
                while (start < numRows && i < s.length()) {
                    rows.get(start).append(s.charAt(i++));
                    start++;
                }
            }
            if (start == numRows) {
                start -= 2;
                start = Math.max(start, 0);
                while (start > 0 && i < s.length()) {
                    rows.get(start).append(s.charAt(i++));
                    start--;
                }
            }
        }

        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}