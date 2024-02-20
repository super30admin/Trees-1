//Brute force approach

// Time Complexity : O(n*h) , finding root index takes o(n) time & Creating a deep copy of all the arrays takes O(2n) time at each recursion level 
// Space Complexity : O(n*h), at each node we are storing 2n space for the arrays
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Choose the root from preorder array and find it's index in inorder arr. Left of index are all the elements to the left of root and 
// same for right subtree. Recursively keep divding the preorder and inorder array to build the left and right subtree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //base
        if(preorder.length == 0) return null;
        
        //root of tree
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int idx = -1; // root index in inorder array
        // finding root index takes o(n) time
        for(int i = 0 ; i < inorder.length ; i++){
            if(inorder[i] == rootVal){
                idx = i;
            }
        }
        // Creating a deep copy of all the arrays takes O(2n) time at each recursion level 
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] inRight = Arrays.copyOfRange(inorder,idx + 1,inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);

        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);

        return root;
    }
}

//Optimized Approach:


// Time Complexity : O(n) , Adding values to map is O(n) finding root index takes o(1) time using mapc & using two pointers takes O(1) time
// Space Complexity : O(n), storing in hashmap
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Optimized the above approach shortcomings by using an hashmap to fetch the index
//in O(1) and used two pointers to mark the start and end ( left and right) of the current root.

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
    int idx;
    HashMap<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;

        this.map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        return helper(0,inorder.length-1,preorder);
    }

    private TreeNode helper(int start , int end , int[] preorder){
        if(start > end) return null; // base condition

        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = map.get(rootVal);// index of root in inorder arr
        //left : start = same & end = root idx -1;
        root.left = helper(start, rootIdx-1,preorder); 
        //right : start = root idx + 1 , end = same;
        root.right = helper(rootIdx+1,end,preorder); 

        return root;
    }
}