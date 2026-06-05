class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Integer> winCounter = new HashMap<>();

        int l = 0;
        int minL = 0;
        int minLen = Integer.MAX_VALUE; 
        
        for (Character c: t.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }

        int need = counter.size();
        int have = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            winCounter.merge(c, 1 , Integer::sum);

            if (counter.containsKey(c) && counter.get(c).intValue() == winCounter.get(c).intValue()) {
                have++;
            }

            while (have == need ) {
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    minL = l;
                }

                char lc = s.charAt(l);
                winCounter.merge(lc, -1, Integer::sum);

                if (counter.containsKey(lc) && winCounter.get(lc).intValue() < counter.get(lc).intValue()) {
                    have--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL + minLen);
    }
}
