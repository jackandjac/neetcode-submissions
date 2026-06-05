/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private Integer result = null;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, new ArrayList<>(), k);
        return result.intValue();
    }

    private void dfs(TreeNode node, List<Integer> list, int k) {
        if (result != null) {
            return;
        }

        if (node != null) {
            dfs(node.left, list, k);
            list.add(node.val);
            if (list.size() == k) {
                result = node.val;
            }
            dfs(node.right, list , k);
        }
    }

}
