// Time Complexity : O(n)
// Space Complexity : O(n) , for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//inorder travel of the BST is always sorted, so we are using this property to prove if a tree is BST or not
//traverse till the left most leaf node, and then pop each time to reach root and then right of root.
//maintain a prev node which should always be lesser than curr node (left<root and right>root)
//when the prev is greater than curr, then the BST is not maintained, return false

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        TreeNode prev=null;
        Stack<TreeNode> res=new Stack<>();
        while (!res.isEmpty() || root!=null){
            while(root!=null){
                res.push(root);
                root=root.left;
            }
        
             root=res.pop();
                 if(prev!=null && prev.val>=root.val){
                     return false;
                 }
            prev=root;
            root=root.right;
        }
        return true;
            
        
        }
        
    }
