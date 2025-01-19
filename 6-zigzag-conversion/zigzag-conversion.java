class Solution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        List<List<Character>> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        int start = 0, i = 0;
        while (i < s.length()) {
            start = Math.max(start, 0);
            if (start == 0) {
                while (start < numRows && i < s.length()) {
                    rows.get(start).add(s.charAt(i++));
                    start++;
                }
            }
            if (start == numRows) {
                start -= 2;
                while (start > 0 && i < s.length()) {
                    rows.get(start).add(s.charAt(i++));
                    start--;
                }
            }
        }

        for (List<Character> row : rows) {
            for (Character character : row) {
                result.append(character);
            }
        }
        return result.toString();
    }
}