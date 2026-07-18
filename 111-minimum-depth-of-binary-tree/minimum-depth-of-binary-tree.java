import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        // Edge case: An empty tree has a depth of 0
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                
                // The first node with no children is the closest leaf node
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                
                // Add children to the queue for the next level
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // Move to the next level
            depth++;
        }
        
        return depth;
    }
}
