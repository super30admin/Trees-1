// time complexity - O(n) n= nodes in tree
// space complexity - O(h) h = height of tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    //TreeNode prev = null;
    bool isValid = true;
    public bool IsValidBST(TreeNode root) {
        InOrder(root,null,null);
        return isValid;
    }

    public void InOrder(TreeNode root,int? min, int? max)
    {
        if(root == null)
        {
            return;
        }
        if(max!=null && root.val>= max)
        {
            isValid = false;
        }
        if(min!=null && root.val<= min)
        {
            isValid = false;
        }
        InOrder(root.left,min,root.val);

        InOrder(root.right, root.val,max);

    }
}