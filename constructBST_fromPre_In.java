//Approach-1 ->Brute Force
// Time Complexity : O(n^2) , n= size of inorder array
// Space Complexity : O(n^2)  ; making new array in each call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        //getting the root value
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        
        //finding index of rootvalue in inorder
        for(int i=0;i<inorder.length;i++){  //O(n) ->finding root for every call
            if(inorder[i] == rootVal){
                rootIdx = i;
            }
        }
        //O(n)-> building arrays everytime
        int[] inLeft = Arrays.copyOfRange(inorder , 0,rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder ,rootIdx+1 ,inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder , 1,1+rootIdx); //or from 1 to 1+inleft.length
        int[] preRight = Arrays.copyOfRange(preorder , rootIdx+1,preorder.length);
        
        root.left = buildTree(preLeft , inLeft);
        root.right = buildTree(preRight , inRight);
        return root;
        
    }
}


//Approach-2 (using two ptrs and hashmap)
// Time Complexity : O(n) , n= size of inorder array
// Space Complexity : O(n)  ; storing in hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    HashMap<Integer,Integer> map;
    int idx;  //ptr on preorder array which will give next root
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null
        if(preorder == null || preorder.length == 0) return null;
        //storing elements in hashmap of inorder array
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
        
    }
    private TreeNode helper(int[] preorder, int start , int end){
        //base
        if(start>end) return null;
        //logic
        int rootVal = preorder[idx]; //value at idx is the next root
        int rootIdx = map.get(rootVal); //index of root in inorder array
        idx++;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start,rootIdx-1 );  //start = start index of parent , end = rootIdx-1
        root.right = helper(preorder , rootIdx+1,end);  //start = rootIdx+1 , end = end index of parent
        return root;
    }
}