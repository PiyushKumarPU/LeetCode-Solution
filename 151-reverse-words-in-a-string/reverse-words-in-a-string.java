class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int end = s.length() - 1;

        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }

            if (end < 0) break;

            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }

            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(s, start + 1, end + 1);
            end = start - 1;
        }
        return builder.toString();
    }
}