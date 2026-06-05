class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> freq.get(b) - freq.get(a));
        for (int num: nums) {
            freq.merge(num, 1, Integer::sum);
        }
        for (int key: freq.keySet()){
            queue.offer(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = queue.poll();
        }

        return res;
    }
}
