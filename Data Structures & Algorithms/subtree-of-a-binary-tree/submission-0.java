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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(isSameTree(node, subRoot)) {
                return true;
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        } 
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
