class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (idxMap.containsKey(c)) {
                l = Math.max(idxMap.get(c), l);
            }
            max = Math.max(max, i - l + 1);
            idxMap.put(c, i + 1);
        }
        return max;
    }
}
