//105.
//time - O(n) - every element in prorder or inorder is visisted only once
//space - O(h) - height of tree, if new arrays are not used
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length == 0)
        {
            return null;
        }
        //build the root -> 1st element in preorder array
        TreeNode root = new TreeNode(preorder[0]);
        
        //find root in inorder to calculate the size of left and right subtrees
        int rootIndex = 0;
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == root.val)
            {
                rootIndex = i;
            }
        }
        
        //recalculate the arrays
        int[] pre_left = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] in_left = Arrays.copyOfRange(inorder, 0, rootIndex);
        
        int[] pre_right = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] in_right = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        
        //recursively build left ans right subtrees
        root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right, in_right);
        return root;
    }
}
