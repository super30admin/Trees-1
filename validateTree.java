// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

import java.util.Stack;
public class validateTree {

    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        
        while(root!=null || !stack.isEmpty()){
            
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            
        if(prev != null && prev.val >= root.val)
            return false;
            
        prev=root;
        root=root.right;

        }
        
        return true;
    }
    
}
