class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       List<Interval> result = new ArrayList<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int[] arr : intervals) intervalList.add(new Interval(arr[0], arr[1]));
        int index = 0;
        while (index < intervalList.size() && intervalList.get(index).end < newInterval[0]) {
            result.add(intervalList.get(index));
            index++;
        }
        if (index == intervalList.size()) result.add(new Interval(newInterval[0], newInterval[1]));
        else {
            Interval current = new Interval(newInterval[0], newInterval[1]);
            for (int i = index; i < intervalList.size(); i++) {
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

        }
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