//The approach here is to check for every left node, if it is in the range of -inf to the parent value. For the right node, it's value should be within the range of it's parent value and the root value
//Time Complexity: O(n)
//Space Complexity: O(h) where h is the length of the tree from root to it's longest leaf
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

    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode node, Integer min, Integer max){
        //base
        if(node == null) return;

        //left
        helper(node.left, min, node.val);

        if(min!= null && node.val <=min){
            flag = false;
        }
        if(max!= null && node.val >= max){
            flag = false;
        }
        
        //right
        helper(node.right, node.val, max);
    }


}