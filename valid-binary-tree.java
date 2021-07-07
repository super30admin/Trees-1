// Time Complexity :  O(N)        
// Space Complexity : O(H)       
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack <TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
    }
}