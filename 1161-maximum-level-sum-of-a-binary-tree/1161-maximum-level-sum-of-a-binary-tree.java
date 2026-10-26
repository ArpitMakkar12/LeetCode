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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int currSum = 0;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                currSum += curr.val;

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(currSum > maxSum){
                maxSum = currSum;
                maxLevel = currLevel;
            }

            currLevel++;
        }

        return maxLevel;
    }
}