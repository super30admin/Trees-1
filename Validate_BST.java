// Iterative Solutio

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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!= null || !st.isEmpty()){
            while(root!= null) {
            st.push(root);
            root= root.left;
        }
        root = st.pop();
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        root = root.right;  
        
    }
        return true;
    }

    
    //Recursion
    
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
    // TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        // Stack<TreeNode> st = new Stack<>();
        
        inorder(root, null);
        return true;
        
      
    }
    
    private boolean inorder(TreeNode root, TreeNode prev){
        
        if(root == null) return true;
        
         // while(root!= null || !st.isEmpty()){
        if(inorder(root.left, prev) == false) return false; 
        // root = st.pop();
        // System.out.println(root.val);
            if(prev != null && prev.val >= root.val) return false;
                prev = root;
        // root = root.right;  
                return inorder(root.right, prev);
        
    }
        
    

}
}

//Time complexity - O(H)
