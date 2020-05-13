Prob-1: 
/**
 * // Time Complexity : O(n) n is the number of nodes in the tree
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 /**
 * Three line comment: This recursive solution uses simple approach checking min and max of each node. 
 * Each node's min value on cannot be less than its left subtree. Each node's max value cannot be greater than its root.
 * If the above mentioned rules are breached than return false otherwise return true.
 */
class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        
        return helper(root, null, null); // to represent -/+ infinity, null is used
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        if((max != null && root.val >= max )|| (min != null && root.val <= min)) return false; 
        //logic
       return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        
    }
}

Prob-2: 
/**
 * // Time Complexity : O(n) where n is the number of elements in the preorder array
 * // Space Complexity : O(n) n number of elements in the array stored in the hashMap
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 /**
 * Three line comment: This recursive solution uses two pointers to build a tree from give inorder and preorder given array. The root is taken from the first element
 * of the preorder array ( root -> left -> right pattern).
 * And the left and right subtree of the current root is at the start to index-1 of the root and index +1 to end of the inorder array respectively.
 */
 class Solution {
    HashMap<Integer, Integer> map;
    int index=0;
    private TreeNode helper(int[] preorder,int start, int end ){
        //base
        if(start > end || index == preorder.length) return null;
        
        //logic
        int inIdx = map.get(preorder[index]); // inIdx = index of the root from the Inorder array
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        
        root.left = helper(preorder, start, inIdx-1);
        root.right = helper(preorder, inIdx+1, end);
        
        return root;
        
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i] ,i);
        }
        return helper(preorder,0,inorder.length-1);        
    }
}
