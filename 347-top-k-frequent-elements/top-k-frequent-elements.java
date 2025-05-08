class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k)
                minHeap.poll();

        }

        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty())
            result[index++] = minHeap.poll().getKey();

        return result;
    }
}