/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        int index=-1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==preorder[0])
            {
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(preorder[0]);
        
        int[] inLeft= Arrays.copyOfRange(inorder,0,index);
        int[] inRight= Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] preLeft= Arrays.copyOfRange(preorder,1,index+1);
        int[] preRight= Arrays.copyOfRange(preorder, index+1,preorder.length);
        
        root.left=buildTree(preLeft,inLeft);
        root.right=buildTree(preRight,inRight);
        return root;
        
    }
}

// Time Complexity: O(n2) as we are having for loop in every recusrion call . Here we are checking elements from an array everytime.

// Space Complexity: O(n) as we are making 4 new arrays everytime, so asymptotically its n.