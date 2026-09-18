class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] freq = new List[n +1];

        Map<Integer, Integer> counter = new HashMap<>();

        for (int num: nums) {
            counter.merge(num, 1, Integer::sum);
        }
        for(int key: counter.keySet()) {
            int f = counter.get(key);
            if (freq[f] == null) {
                freq[f] = new ArrayList<>();
            }
            freq[f].add(key);
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length -1; i>= 0  && idx < k; i--){
            if (freq[i] != null) {
                for (int j = 0; j < freq[i].size() && idx < k; j++ ) {
                    res[idx++] = freq[i].get(j);
                }
            }
        }
        return res;
    }
}
