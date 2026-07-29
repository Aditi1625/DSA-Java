import java.util.HashMap;
import java.util.Map;

// Definition for a binary tree node.
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
    
    private int preIdx = 0;
    
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int leftBound, int rightBound) {
        
        if (leftBound > rightBound) {
            return null;
        }

        
        int rootVal = preorder[preIdx];
        preIdx++;
        
        TreeNode root = new TreeNode(rootVal);

        
        int pivot = inorderMap.get(rootVal);

        
        root.left = arrayToTree(preorder, leftBound, pivot - 1);
        
        
        root.right = arrayToTree(preorder, pivot + 1, rightBound);

        return root;
    }
}
