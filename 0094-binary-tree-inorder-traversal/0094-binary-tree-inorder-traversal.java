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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                // print curr
                ans.add(curr.val);
                curr = curr.right;
            } else {
                // find Inorder Predecessor(IP):
                TreeNode ip = curr.left;
                while(ip.right != null && ip.right != curr) {
                    ip = ip.right;
                }
                if(ip.right == null) {
                    ip.right = curr; // create thread
                    curr = curr.left;
                } else {
                    ip.right = null; // delete thread
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}