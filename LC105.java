import java.util.HashMap;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
/*
Time: O(n)
Space: O(n) for runtime stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class LC105 {

    HashMap<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int iStart = 0;
        int iEnd = inorder.length - 1;
        int pRoot = 0;

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i); // memoization

        return helper(preorder, inorder, iStart, iEnd, pRoot);

    }

    public TreeNode helper(int[] preorder, int[] inorder, int iStart, int iEnd, int pRoot) {
        if (iStart > iEnd)
            return null;

        // Output root node is nothing but starting node of preorder
        TreeNode root = new TreeNode(preorder[pRoot]);

        // Find the position of the root node in the inorder array
        int iRoot = map.get(preorder[pRoot]);

        root.left = helper(preorder, inorder, iStart, iRoot - 1, pRoot + 1); // Left in preorder is simply pRoot+1
        root.right = helper(preorder, inorder, iRoot + 1, iEnd, pRoot + (iRoot - iStart) + 1);

        return root;

    }

}
