class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                result.add(new Interval(interval[0], interval[1]));
            } else if (newInterval[1] < interval[0]) {
                result.add(new Interval(newInterval[0], newInterval[1]));
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(new Interval(newInterval[0], newInterval[1]));
        return result.stream()
                .map(interval -> new int[]{interval.start, interval.end})
                .toArray(int[][]::new);
    }
}

class Interval {
    Integer start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}