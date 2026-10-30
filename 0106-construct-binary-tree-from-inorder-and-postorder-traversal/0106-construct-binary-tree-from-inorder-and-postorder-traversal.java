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
    int postIdx;

    public int search(int[] inorder, int left, int right, int val){
        for(int i = left; i <= right; i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }

    public TreeNode helper(int[] inorder, int[] postorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootVal = postorder[postIdx--];

        TreeNode root = new TreeNode(rootVal);
        int inorderIdx = search(inorder, left, right, rootVal);

        root.right = helper(inorder, postorder, inorderIdx + 1, right);
        root.left = helper(inorder, postorder, left, inorderIdx - 1);
        

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
}