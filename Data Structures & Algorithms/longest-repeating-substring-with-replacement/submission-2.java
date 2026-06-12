class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0;

        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'A']++;
            maxFreq = Math.max(freq[c - 'A'], maxFreq);

            while( i - l + 1 - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
