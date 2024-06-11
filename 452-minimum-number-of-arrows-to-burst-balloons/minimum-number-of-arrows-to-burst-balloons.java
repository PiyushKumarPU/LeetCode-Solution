class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort the points by the end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // We need at least one arrow
        int currentEnd = points[0][1]; // End point of the first balloon

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentEnd) {
                // If the current balloon starts after the end of the previous one
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }
}