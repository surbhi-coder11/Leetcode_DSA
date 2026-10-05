import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        // Append the current node's value to the path string
        path += node.val;

        // If it's a leaf node, add the accumulated path to the result list
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        // If left child exists, recurse with "->" separator appended
        if (node.left != null) {
            dfs(node.left, path + "->", paths);
        }

        // If right child exists, recurse with "->" separator appended
        if (node.right != null) {
            dfs(node.right, path + "->", paths);
        }
    }
}