//https://leetcode.com/problems/validate-binary-search-tree/description/
//Time Complexity: O(n)
//Space Complexity: O(h) : height of the tree

//Recurrsive
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer min, Integer max){
        //base
        if(root == null){
            return true;
        }
        //logic
        //breach of BST property on left subtree || breach on right subtree
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }

        return (validate(root.left, min, root.val) && validate(root.right, root.val, max));
    }
}