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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorderTraverse(result, root);
        return result.get(k - 1);
    }

    private void inorderTraverse(List<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }

        inorderTraverse(result, root.left);
        result.add(root.val);
        inorderTraverse(result, root.right);
    }
}
