class Solution {
    public int[] countBits(int n) {
        int[] array = new int[n +1];
        for (int i = 0; i <= n; i++) {
            int candidate  = i;
            int res = 0;
            while(candidate != 0) {
                if ((candidate & 1) == 1) {
                    res++;
                }
                candidate = candidate >> 1;
            }
            array[i] = res;
        }
        return array;
    }
}
