/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h) where height of the tree.
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    boolean dfs(TreeNode node, Integer min, Integer max){
        //Base case

        if (
                (min != null && node.val <= min) ||
                        (max != null && node.val >= max)
        ) {
            return false;
        }

        if(node.left == null && node.right == null){
            return true;
        }

        //Recursion case
        boolean isValid = true;

        if(node.left != null){
            if(node.val <= node.left.val){
                isValid = false;
            }
            isValid = isValid && dfs(node.left, min, node.val);
        }

        if(node.right != null){
            if(node.val >= node.right.val ){
                isValid = false;
            }
            isValid = isValid && dfs(node.right, node.val, max);
        }

        return isValid;
    }
}