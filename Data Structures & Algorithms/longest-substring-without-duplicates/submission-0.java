class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cmap = new HashMap<>();
        int max = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cmap.containsKey(c)){
                j = Math.max(j, cmap.get(c));
            }
            max = Math.max(max, i - j +1);
            cmap.put(c, i + 1);
        }
        return max;
    }
}
