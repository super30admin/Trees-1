// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //Approach 2 HashMap TC:O(n) SC:O(n)
    HashMap<Integer, Integer> hm = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        
        for( int i =0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int start, int end){
        
        //base
        if(start>end) return null;
        //logic
        int rootVal = preorder[idx];
        int rootId = hm.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start,rootId-1);
        root.right = helper(preorder, rootId+1,end);
        return root;
    }
    //Approach 1 TC: O(n^2) SC: O(n^2)
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
//         int  i = 0;
        
//         //base
//         int rootValue = preorder[0];
//         TreeNode root = new TreeNode(rootValue);
//         int rootId= -1;
        
//         //logic
        
//         while(rootValue != inorder[i]){ //O(n)
//             i++;
//         }
//         rootId = i;
//         // pre [3,9,20,15,7]  3 is root; length of left subtree will be inleft length
//         // in  [9,3,15,20,7] //9 is left subtree, rootId = 1 index;
//         int[] inLeft = Arrays.copyOfRange(inorder,0,rootId); O(n)
//         int[] inRight =  Arrays.copyOfRange(inorder,rootId+1,inorder.length);
//         int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);// first element will always be root so start from 1 index
//         int[] preRight = Arrays.copyOfRange(preorder,rootId+1,preorder.length);
//         root.left = buildTree(preLeft,inLeft);
//         root.right = buildTree(preRight,inRight);
//         return root;
//     }
}