// Leetcode 98. Validate Binary Search Tree
/** 3 Pointer Approach: 
    1. Here, not only the right child should be larger than the node but all the elements in the right subtree.{same left tree}
    2. For iterative, used STACK to keep track of Node and useing Inorder Traversal.
    3. Left -> Node -> Right order of inorder traversal means for BST that each element should be smaller than the next one.
    4. Check if each element in inorder is smaller than the next one.
 */  
//
//time Complexity :
// O(N)

// Space Complexity :
// O(H)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

class Solution {
           
    public boolean isValidBST(TreeNode root) {       
       
        if(root == null) return true;
        Integer prev = null; 
        Stack<TreeNode> stk = new Stack<>();
        
        while(root != null || !stk.isEmpty()){
            
            while(root != null){   
                stk.add(root);
                root = root.left;
            }
            
            root = stk.pop(); 
            
           if(prev != null && prev >= root.val) return false;
           else prev = root.val;            
           
            root = root.right;
        }
        
        return true;
    }
}