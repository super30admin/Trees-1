//Validate BST

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

 // LIMIT APPROACH
 class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        //base
        if(root == null) return true;
        if(min!=null && root.val <= min) return false;
        if(max!=null && root.val >= max)  return false;

        //logic 
        /*boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);    

        return left && right;  */
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}



//Consrtuct BT from Inorder and Preorder traversal

//Brute Force Approach 
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;

        int rootVal = preorder[0];
        int idx = -1;
        TreeNode root = new TreeNode(rootVal);
        

        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)
            {
            idx = i;
            break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
