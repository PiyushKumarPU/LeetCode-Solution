class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        HashMap<Integer, Integer> colorCountMap = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColorMap.containsKey(ball)) {
                int existingColor = ballColorMap.get(ball);
                colorCountMap.put(existingColor, colorCountMap.get(existingColor) - 1);
                if (colorCountMap.get(existingColor) == 0) {
                    colorCountMap.remove(existingColor);
                }
            }
            ballColorMap.put(ball, color);
            colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);
            result[i] = colorCountMap.size();
        }
        return result;
    }
}