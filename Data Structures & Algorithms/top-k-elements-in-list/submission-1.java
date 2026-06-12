class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num: nums) {
            counter.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> counter.get(b)- counter.get(a));
        for(int key: counter.keySet()){
            queue.offer(key);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = queue.poll().intValue();
        }

        return res;
    }
}
