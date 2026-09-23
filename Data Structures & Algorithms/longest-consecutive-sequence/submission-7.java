class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> nset = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for (int num: nset){
            if (!nset.contains(num -1)){
                int len = 1;
                int cur = num;

                while(nset.contains(cur +1) ) {
                    len++;
                    cur++;
                }
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
