class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int res = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n -1; i++) {
            if (s.charAt(i) == s.charAt(i +1)) {
                dp[i][i +1] = true;
                res++;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0, k = i + j; k < n; j++, k++) {
                dp[j][k] = s.charAt(j) == s.charAt(k) && dp[j +1][k -1];
                if (dp[j][k]) {
                    res++;
                }
            }
        }
        return res;
    }
}
