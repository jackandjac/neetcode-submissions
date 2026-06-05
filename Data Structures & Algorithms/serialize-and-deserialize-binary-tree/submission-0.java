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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return ser(root,  new StringBuilder());
    }
    private String ser(TreeNode node, StringBuilder sb ) {
        if (node == null) {
            sb.append("null,");
            return sb.toString();
        }

        sb.append(node.val).append(',');
        this.ser(node.left, sb);
        this.ser(node.right, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return dser(list);
    }
    private TreeNode dser(List<String> list){
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        String sval = list.get(0);
        int val = Integer.parseInt(sval);
        TreeNode node = new TreeNode(val);
        list.remove(0);

        node.left = dser(list);
        node.right = dser(list);
        return node;
    }
}
