class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        String res = s.substring(0,1);
        for (int i= 0; i < n -1; i++) {
            if (s.charAt(i) == s.charAt(i +1)) {
                dp[i][i+1] = true;
                res = s.substring(i, i + 2);
            }
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0, k = i + j; k < n; j++, k++ ){
                dp[j][k] = s.charAt(j) == s.charAt(k) && dp[j + 1][k-1];
                if (dp[j][k]) {
                    if (k - j + 1 > res.length()) {
                        res= s.substring(j, k +1);
                    }
                }
            }
        }
        return res;
    }
}
