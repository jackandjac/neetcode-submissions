class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        for(int candidate: set) {
            if (!set.contains(candidate -1)) {
                int len = 1;
                while(set.contains(candidate +1)){
                    len++;
                    candidate++;

                }
                max = Math.max(max,  len);
            }
        }
        return max;
    }
}
