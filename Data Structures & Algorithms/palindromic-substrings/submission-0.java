class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < n -1; i++) {
            if (s.charAt(i) == s.charAt(i +1)) {
                dp[i][i +1] = true;
                count++; 
            }
        }
        for (int i =2; i < n; i++) {
            for (int j = 0, k = i + j; k <n; k++, j++) {
                dp[j][k] = dp[j+1][k-1] && s.charAt(j) == s.charAt(k);
                if (dp[j][k]) {
                    count++;
                }
            }
        }
        return count;
    }
}
