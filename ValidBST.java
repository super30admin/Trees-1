// Time Complexity :O(n) where n is the number of nodes
// Space Complexity : O(log n) in the best case scenario and O(n) in the worst cases
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
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
class ValidBST {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inOrderTraversal(root);
        return this.flag;
    }

    public void inOrderTraversal(TreeNode root){
        if(!flag || root == null) return;

        inOrderTraversal(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        inOrderTraversal(root.right);
    }

}