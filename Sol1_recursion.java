// Leetcode 98. Validate Binary Search Tree
/** 3 Pointer Approach: 
    1. Here, not only the right child should be larger than the node but all the elements in the right subtree.{same left tree}
    2. Hence, need to keep both upper and lower limits for each node while traversing the tree, and compare the node value not with children values but with these limits.
    3. Compares the node value with its upper and lower limits.
    4. Repeat recursive steps for left and right subtrees

 */  
//
//time Complexity :
// O(N)

// Space Complexity :
// O(H) height of tree

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

public class Sol1_recursion {
      
    public boolean isValidBST(TreeNode root) {       
        return recursionCheck(root, null, null);
    }


    boolean recursionCheck(TreeNode root, Integer low, Integer high){
        
        if(root == null) return true; //base case

        int val = root.val;
        
        if(low != null && val <= low) return false;
        if(high != null && val >= high) return false;
             
            
        if(!recursionCheck(root.left, low, val)) return false;
        if (!recursionCheck(root.right, val, high)) return false;
    
        return true;
    }

}