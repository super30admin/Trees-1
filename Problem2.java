// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.Arrays;
import java.util.HashMap;
// Your code here along with comments explaining your approach
// Approach 1: Brute force
// Time Complexity : O(n^2)
//      n: number of elements
//      As for every element we need to find root
// Space Complexity : O(n^2)
//      n: number of elements
//      As for every element we have to create a copy
class Problem2S1 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** returns a BST tree */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 || inorder.length==0 || preorder.length != inorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for(int i=0;i<inorder.length;i++ ){
            if(inorder[i]== root.val){
                index = i;
                break;
            }
        }
        
        // breaking it into left and right subtree
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight=  Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight= Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        // recursive build right and left
        root.left = buildTree(preLeft,  inLeft);
        root.right = buildTree(preRight,  inRight);
        
        return root;
        
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using HashMap and pointers
// Time Complexity : O(n)
//      n: number of elements
// Space Complexity : O(n)
//      n: number of elements
//      For HashMap
class Problem2S2 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // global hash map for storing inorder index
    HashMap<Integer, Integer> map;
    // global pointer for root
    int preOrderRoot= 0;

    /** return tree */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // base condition
        if(preorder.length ==0 || inorder.length==0 || preorder.length != inorder.length)
            return null;
        // creating map
        map =  new HashMap<>();
        for(int i=0; i<inorder.length;i++)
            map.put(inorder[i], i);
        
        // return tree
        return helper(preorder, inorder,0, inorder.length-1);
        
    }
    
    /** helper function */
    private TreeNode helper(int[] preorder, int[] inorder,int start, int end){
        // base case
        if(start>end)
            return null;
        // find inorder index of root
        int rootIdx = map.get(preorder[preOrderRoot++]);
        // creating root
        TreeNode root = new TreeNode(inorder[rootIdx]);
        // left-sub tree
        root.left = helper(preorder, inorder, start, rootIdx-1);
        // right-sub tree
        root.right = helper(preorder, inorder, rootIdx+1, end);
        // return tree
        return root;
        
    }
    // Note:
    // We take a global root index of preorder
    // As 1st index(Oth) is always root of that sub tree.
    // And also for recursive call we are going left and then right sub-tree.
}