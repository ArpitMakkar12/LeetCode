
class Solution {

    void allPaths(TreeNode root, String path, List<String> ans) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        if (root.left != null) {
            allPaths(root.left, path + "->" + root.left.val, ans);
        }

        if (root.right != null) {
            allPaths(root.right, path + "->" + root.right.val, ans);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        String path = Integer.toString(root.val);

        allPaths(root, path, ans);

        return ans;
    }
}
