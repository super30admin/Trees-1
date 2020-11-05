// Time Complexity : O(n), where n is the number of nodes in the tree (time requried to copy elements from inorder array to hashMap)
// Space Complexity : O(n), O(n), where n is the number of nodes in the tree (space required for hashMap)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was trying to pass the preorderIndex as a local variable instead of global in recursion,
                                                //but didnt work so wanted to know why?

//three liner explanation of your code in plain english
//1. create a hashMap and copy all the elements from the inorder array to hashMap. Assign 1 pointer at start of preorder array ,
        //and 2 pointer at start and end of the inorder array
//2. Here also we find the root in the inorder and the preorder array, and then then their left and right subtree, But instead of creating
        //different arrays, we adjust the above pointers in the same arrays where it might have started and ended in the newly formed array.
//3. continue doing this till the start and the end index of inorder have not crossed or are at the same location


// Your code here along with comments explaining your approach

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
    //pointer to get root from the preorder array
    int preIdx;
    //hashMap to store the inorder array, inorder to find root in constant time
    HashMap<Integer, Integer> hMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 && inorder.length ==0) return null;
        hMap = new HashMap<>();
        //putting all values from inorder array to hashMap
        for(int i=0; i<inorder.length; i++){
            hMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd){
        //base
        if(inStart > inEnd ) return null;
        //logic
        int rootVal = preorder[preIdx];
        //find the root in the inorder array
        int inIdx = hMap.get(rootVal);
        //create the root node
        TreeNode root = new TreeNode(rootVal);
        preIdx++;
        //find the left child of the root
        root.left = helper(preorder, inorder, inStart,inIdx -1);
        
        //find the right child of the root
        root.right = helper(preorder, inorder, inIdx+1, inEnd);
        
        //the root holds the tree
        return root;
    }
}