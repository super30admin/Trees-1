/*
space complexity = O(N)
run time complexity = O(N)
*/

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
    int index;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
         map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    
    public TreeNode helper(int[] preorder,int start, int end)
    {
        if(start>end)
            return null;
        int idx=map.get(preorder[index]);
        TreeNode root=new TreeNode(preorder[index]);
        index++;        
        root.left=helper(preorder,start,idx-1);
        root.right=helper(preorder,idx+1,end);
        return root;
    }
   
}

/*
public TreeNode helper(int[] preorder, int[] inorder)
{
    if(preorder.length==0)
        return null;
    TreeNode root=new TreeNode(preorder[0]);
    int index=-1;
    for(int i=0;i<inorder.length;i++)
    {
        if(inorder[i] == preorder[0]) // this is a costly operation to find the index of the element in preorder - to avoid this, we can use the hashmap 
            index=i;
    }
    int[] preorder_left=Arrays.copyOfRange(preorder,1,index+1);
    int[] preorder_right=Arrays.copyOfRange(preorder,index+1,preorder.length);
    int[] inorder_left=Arrays.copyOfRange(inorder,0,index);
    int[] inorder_right=Arrays.copyOfRange(inorder,index+1,inorder.length);
    root.left=buildTree(preorder_left,inorder_left);
    root.right=buildTree(preorder_right,inorder_right);
    return root;
}
*/


