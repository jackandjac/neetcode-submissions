class MedianFinder {
    private PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()){
            return (max.peek() + min.peek())/2.0;
        } else {
            return max.peek();
        }
    }
}
