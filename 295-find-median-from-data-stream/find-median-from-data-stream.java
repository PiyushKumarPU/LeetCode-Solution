class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int currentMax = maxHeap.isEmpty() ? Integer.MAX_VALUE : maxHeap.peek();
        if(num > currentMax) minHeap.offer(num);
        else maxHeap.offer(num);
        int difference = maxHeap.size() - minHeap.size();
        if(difference > 1) minHeap.offer(maxHeap.poll());
        else if(difference < 0) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        int totalSize = maxHeap.size() + minHeap.size();
        if(totalSize % 2 == 0) {
            int max = maxHeap.isEmpty() ? 0 : maxHeap.peek();
            int min = minHeap.isEmpty() ? 0 : minHeap.peek();
            double sum = (double)(max + min);
            return sum/2d;
        }
        else return (double)maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */