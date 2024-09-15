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
//Iterative solution
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()){
            while(root != null ){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }  
        return true;
    }
}

/*
H is height of the tree
Time Complexity : O(H) 
Space Complexity: O(H)
*/


//Recursive solution
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
    TreeNode prev ;
    
    public boolean isValidBST(TreeNode root) {
      return inorder(root);
   }
    
    private boolean inorder(TreeNode root){
        
        //base
        if(root == null ) return true;  //no invalid case reached till the leaf
        
        if( inorder(root.left) == false ) return false;  //till left does not hit an invalid case proceed with the right also otherwise stop
        if(prev != null && prev.val >= root.val ) return false;
        prev = root;
        return inorder(root.right);
    }
}
/*
H is height of the tree
Time Complexity : O(H) 
Space Complexity: O(H)
*/

