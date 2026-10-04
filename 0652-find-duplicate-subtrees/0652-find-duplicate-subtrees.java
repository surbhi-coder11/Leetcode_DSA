import java.util.*;

class Solution {
    // Map to store unique subtree structures and assign them a unique ID
    Map<String, Integer> subTreeToId = new HashMap<>();
    // Map to count frequency of each subtree ID
    Map<Integer, Integer> idCount = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    int idCounter = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private int serialize(TreeNode node) {
        if (node == null) {
            return 0; // 0 represents null nodes
        }

        // Post-order traversal: Left -> Right -> Current Node
        int leftId = serialize(node.left);
        int rightId = serialize(node.right);

        // Create a unique structure representation for the current subtree
        String subtreeKey = node.val + "," + leftId + "," + rightId;

        // Get or assign a unique ID for this subtree structure
        int subtreeId = subTreeToId.getOrDefault(subtreeKey, idCounter);
        if (subtreeId == idCounter) {
            idCounter++;
            subTreeToId.put(subtreeKey, subtreeId);
        }

        // Track frequency of this subtree ID
        idCount.put(subtreeId, idCount.getOrDefault(subtreeId, 0) + 1);

        // If it appears for the second time, add its root to the result list
        if (idCount.get(subtreeId) == 2) {
            result.add(node);
        }

        return subtreeId;
    }
}