class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> ballMap = new HashMap<>((int) (queries.length / 0.75 + 1));
        Map<Integer, Integer> colorMap = new HashMap<>((int) (queries.length / 0.75 + 1));

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballMap.containsKey(ball)) {
                int oldColor = ballMap.get(ball);

                if (color != oldColor) {
                    int oldColorCount = colorMap.get(oldColor);
                    ballMap.put(ball, color);
                    colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

                    if (oldColorCount == 1) {
                        colorMap.remove(oldColor);
                    } else {
                        colorMap.put(oldColor, oldColorCount - 1);
                    }
                }
            } else {
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            }
            result[i] = colorMap.size();
        }
        return result;
    }
}