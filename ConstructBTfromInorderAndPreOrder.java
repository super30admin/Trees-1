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

// TC : O(N): N: length of inorder array
// SC:  O(N): O(2N) -> O(N) for recursive stack + O(N) for hashmap
// Did it run successfully on Leetcode? : Yes
class Solution {
     HashMap<Integer, Integer> map;
     int index = 0;
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) 
            return null;
         map = new HashMap();
         for ( int i = 0; i < inorder.length; i++)
         {
             map.put(inorder[i], i);
         }
         return helper(preorder, 0, preorder.length -1);       
    }
    private TreeNode helper(int[] preorder, int start, int end)
    {
        //base
        if ( start > end)
            return null; 
        
        // logic
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int root_index = map.get(rootVal);
        root.left = helper(preorder, start, root_index-1);
        root.right = helper(preorder, root_index+1, end);
        return root;
    }
}

// TC : O(N^2): iterting through inorder array N times and creating the auxillary arrays of length N in worst case
// SC:  O(N^2):  recursive stack + creating the auxillary arrays of length N in worst case
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (inorder.length == 0 || preorder.length == 0) 
//             return null;
//          int rootVal = preorder[0];
//          TreeNode root = new TreeNode(rootVal);
//          int index = -1;
//          for ( int i = 0; i < inorder.length; i++)
//          {
//             if (inorder[i] == rootVal)
//                 index = i;
//          }
//          int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
//          int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
//          int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1); 
//          int[] preRight = Arrays.copyOfRange(preorder, index+1,  preorder.length);
//          root.left = buildTree( preLeft, inLeft);
//          root.right = buildTree( preRight, inRight);
//         return root;     
//     }
// }

