class Solution {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> size = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        for (int num: nums) {
            parent.put(num, num);
            size.put(num, 1);
        }

        for (int num: nums) {
            if (parent.containsKey(num +1)){
                union(num, num +1);
            }
        }
        int max = 1;
        for (int num: size.values()){
            max = Math.max(num, max);
        }
        return max;
    }

    private int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }
        if (size.get(py) > size.get(px)) {
            int temp = px;
            px = py;
            py = temp;
        }
        parent.put(py, px);
        size.put(px, size.get(px) + size.get(py));
    }
}
