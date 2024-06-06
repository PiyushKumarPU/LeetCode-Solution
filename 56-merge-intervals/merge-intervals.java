class Solution {
    public int[][] merge(int[][] intervals) {
        List<Interval> result = new ArrayList<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int[] arr : intervals) intervalList.add(new Interval(arr[0], arr[1]));
        intervalList.sort(Comparator.comparingInt((Interval i) -> i.start));
        Interval current = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            Interval next = intervalList.get(i);
            if (current.start <= next.end && current.end >= next.start) {
                current.end = Math.max(current.end, next.end);
                current.start = Math.min(current.start, next.start);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
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