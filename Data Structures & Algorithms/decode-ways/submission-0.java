class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        for (int i = 0; i <= n; i++){
            if (i == 0) {
                dp[i] = 1; 
            } else {
                 dp[i] = 0;
                 int val = s.charAt(i -1) - '0';
                 if (val > 0) {
                    dp[i] += dp[i-1];
                    }
                    if (i > 1) {
                    int nex = (s.charAt(i -2) - '0') *10 + val;
                    if (nex >= 10 && nex <= 26) {
                        dp[i] += dp[i-2];
                    }
                 }

            }
        }
        return dp[n];
    }
}
