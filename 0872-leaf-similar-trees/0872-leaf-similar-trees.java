import java.util.*;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        getLeaves(root1, list1);
        getLeaves(root2, list2);
        
        return list1.equals(list2);
    }
    
    private void getLeaves(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        
        getLeaves(node.left, list);
        getLeaves(node.right, list);
    }
}
