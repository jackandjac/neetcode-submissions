class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        int n = s.length();
        int max = 0, l = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (idxMap.containsKey(c)) {
                l = Math.max(idxMap.get(c), l);
            }

            int len = i - l +1;
            max = Math.max(max, len);
            idxMap.put(c, i + 1);
        }

        return max;
    }
}
