import java.util.Arrays;

// Time Complexity : O(n+m)
// Space Complexity :O(depth of the tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base case
        if(preorder.length==0 || inorder.length==0) return null;
        //1.
        TreeNode root = new TreeNode(preorder[0]);
        int index =-1;
        for(int i =0; i <inorder.length;i++)
        {
            if(inorder[i]==preorder[0])
            {
                index = i;
                break;
            }
        }
        
        int [] left_pre = Arrays.copyOfRange(preorder,1,index+1);
        int [] left_post=Arrays.copyOfRange(inorder,0,index);
        int [] right_pre= Arrays.copyOfRange(preorder,index+1,preorder.length);
        int [] right_post=Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left= buildTree(left_pre,left_post);
        root.right= buildTree(right_pre,right_post);
        return root;
    }
}