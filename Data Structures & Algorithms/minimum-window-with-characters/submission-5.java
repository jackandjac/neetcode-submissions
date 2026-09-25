class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Integer> winCounter = new HashMap<>();

        int l = 0;
        int minL = 0; 
        int minLen = Integer.MAX_VALUE;
        for (char c: t.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }
        int need = counter.size();
        int have = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            winCounter.merge(c, 1, Integer::sum);
            if (counter.containsKey(c) && winCounter.get(c).intValue() == counter.get(c).intValue()) {
                have++;
            }

            while(need == have) {
                if ( i -l +1 < minLen) {
                    minL = l;
                    minLen = i - l +1;
                }
                char lc = s.charAt(l++);
                winCounter.merge(lc, -1, Integer::sum);
                if (counter.containsKey(lc) && winCounter.get(lc).intValue() < counter.get(lc).intValue()){
                    have--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL + minLen);
    }
}
