// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Iterative
class Solution{
    public boolean isValidBST(TreeNode root){
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            //left
            while(root!= null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            //validating BST
            //null check because prev is first initialized as null
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;

            System.out.println(root.val);

            //right
            root = root.right;
        }

        return true;
    }
}