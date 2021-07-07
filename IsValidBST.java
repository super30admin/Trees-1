/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
        // Time Complexity : O(No. of treenodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.Iterative inorder approach using prev variable to compare the current root with previous root
*/
    
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while((root != null) || !(st.empty())){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!= null && root!=null && prev.val>=root.val) return false;
            prev = root;
            root = root.right;
            if(prev!=null && root!=null && prev.val>=root.val) return false; 
        }
        return true;
        
    }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // Time Complexity : O(No. of treenodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.Recursive inorder approach using prev variable to compare the current root with previous root
*/
    
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
           return inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        //base
        if(root == null) return true;
        
        //logic
        if(!inOrder(root.left)) return false;
        if(prev!=null && prev.val>=root.val) return false;
        prev = root;
        return inOrder(root.right);
    }
}







/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // Time Complexity : O(No. of treenodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.Take min and max as arguements f(root,min,max)
2. Moving left --> min, root
3. Moving right --> root, max
*/
    
    public boolean isValidBST(TreeNode root) {
           return inOrder(root, null, null);
    }
    private boolean inOrder(TreeNode root,Integer min, Integer max){
        //base
        if(root == null) return true;
        if((min!= null && root.val<=min) || (max!=null && root.val>=max)) return false;
        //logic        
        return (inOrder(root.left, min, root.val) && inOrder(root.right,root.val, max));
    }
}