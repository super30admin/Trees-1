// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/validate-binary-search-tree/submissions/1057758765/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

import java.util.*;
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        isValid = true;
        inorder(root);
        return isValid;
    }
    void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(prev!=null && prev.val >= root.val){
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);

    }
}

//Iterative solution

class Solution2 {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        isValid = true;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root= s.pop();
            if(prev!=null && prev.val >= root.val){
                isValid = false;
                return false;
            }
            prev=root;
            root= root.right;
        } 
        return isValid;
    }
}