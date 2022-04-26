//iterative solution
// iterative and recirsive appraoches are very similar
// the prev pointer is always a step behind root so if say at any point prev is greater than root then that bst isn't valid
// observe where the prev pointer is coded
// TC: O(N): we are only dealing with N nodes so
// S.C: O(H) where H is height/depth of the tree
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;    
            }
            root = s.pop();
            if(prev != null && prev.val >= root.val) {
                return false; 
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}