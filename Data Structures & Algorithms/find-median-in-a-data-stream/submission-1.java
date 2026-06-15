class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek())/2.0;
        } else {
            return max.peek();
        }
    }
}
