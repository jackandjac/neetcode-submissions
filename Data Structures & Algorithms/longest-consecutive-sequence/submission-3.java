class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int num: nums) {
            set.add(num);
        }

        for(int candidate: set) {
            if (!set.contains(candidate -1)) {
                int len = 1;

                while(set.contains(candidate + 1)){
                    len++;
                    candidate++;
                    max = Math.max(max, len);
                } 
            }
        }
        return max;
    }
}
