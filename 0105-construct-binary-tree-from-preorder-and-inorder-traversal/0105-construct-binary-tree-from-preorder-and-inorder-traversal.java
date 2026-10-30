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

    int preIdx = 0;

    public int search(int[] inorder, int left, int right, int val){

        for(int i = left; i <= right; i++) {
            if(inorder[i] == val){
                return i;
            }
        }

        return -1;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        
        int inorderIdx = search(inorder, left, right, root.val);
        root.left = helper(preorder, inorder, left, inorderIdx - 1);
        root.right = helper(preorder, inorder, inorderIdx + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}