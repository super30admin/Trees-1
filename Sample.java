             // Construct Binary Tree from Preorder and Inorder Traversal

// TC : O(n)
// SC : O(n + h) .. h is space used by recursive stack of recurse function

class Solution {

    Map<Integer, Integer> map;
    int index = 0;

    private TreeNode recurse(int[] preorder, int start, int end){

        if(start > end)
            return null;

        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = recurse(preorder, start, rootIndex - 1);
        root.right = recurse(preorder, rootIndex+1, end);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        
        return recurse(preorder, 0, inorder.length-1);
    }
}

             // Validate Binary Search Tree

// TC : O(n)
// SC : O(h) .. h is space used by recursive stack of recurse function

class Solution {

    private boolean isBST(TreeNode root, Integer min, Integer max){

        if(root == null)
            return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        else 
            return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null ,null);
    }
}
