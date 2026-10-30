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

    static class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = 0;

        while(!q.isEmpty()){
            int currLevelSize = q.size();
            long stIdx = q.peekFirst().idx;
            long endIdx = q.peekLast().idx;

            maxWidth = Math.max(maxWidth, (int)(endIdx - stIdx) + 1);

            for(int i = 0; i < currLevelSize; i++) {
                Pair curr = q.poll();
                TreeNode currNode = curr.node;
                long currIdx = curr.idx - stIdx;

                if(currNode.left != null) {
                    q.add(new Pair(currNode.left, currIdx * 2 + 1));
                }

                if(currNode.right != null){
                    q.add(new Pair(currNode.right, currIdx * 2 + 2));
                }
            }
        }

        return maxWidth;
    }
}