class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer>[] bucket = new List[n +1];
        for(int num: nums) {
            counter.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        } 

        int[] res = new int[k];
        int idx = 0;

        for (int i = n; i > 0; i--) {
            if (bucket[i] == null) {
                continue;
            }

            for (int num: bucket[i]) {
                res[idx++] = num;
                if (idx == k ) {
                    return res;
                }
            }
        }
        return res;
    }
}
