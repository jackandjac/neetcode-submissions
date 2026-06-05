class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int len = 1;
        String res = "";
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        res = s.substring(n-1, n);

        for (int i = 0; i < n -1; i++) {
            if (s.charAt(i) == s.charAt(i +1) ){
                dp[i][i+1] = true;
                len = 2;
                res = s.substring(i, i+2);
            }
        }
        for (int i = 2; i < n ; i++) {
            for (int j = 0, k = i + j; k< n; j++, k++){
                dp[j][k] = s.charAt(j) == s.charAt(k) && dp[j+1][k-1];
                if (dp[j][k] && len < k - j + 1){
                    len = k - j +1;
                    res = s.substring(j, k +1);
                }
            }
        }
        return res;
    }
}
