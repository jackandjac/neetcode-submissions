class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int max = 0;

        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pos.containsKey(c)) {
                l = Math.max(l, pos.get(c).intValue());
            } 
            max = Math.max(max, i - l +1);
            pos.put(c, i +1);
        }

        return max;
    }
}
