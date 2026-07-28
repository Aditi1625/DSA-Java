import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
    private Map<String, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();


        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        
        String memoKey = start + "-" + end;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        
        for (int i = start; i <= end; i++) {
            
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);

            
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        
        memo.put(memoKey, allTrees);
        return allTrees;
    }
}
