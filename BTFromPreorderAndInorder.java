import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(h+n) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
This Java code reconstructs a binary tree from its preorder and inorder traversal arrays.
 It utilizes a HashMap to store the indices of elements in the inorder array for quick lookup,
 which optimizes the process of identifying the root positions. The recursive helper function builds
 the tree by selecting the current root from the preorder array and partitioning the inorder array
 into left and right subtrees. The idx variable keeps track of the current position in the preorder
 array. This approach ensures a time complexity of O(n) and a space complexity of O(h), where h is
  the height of the tree.

*/
class BTFromPreorderAndInorder {
    int idx=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return helper(preorder,0,preorder.length-1);

    }

    private TreeNode helper(int[] preorder,int start,int end)
    {
        if(start>end)
            return null;
        int root=preorder[idx];
        idx++;
        int rootIdx=map.get(root);



        TreeNode root1=new TreeNode(root);

        root1.left=helper(preorder,start,rootIdx-1);
        root1.right=helper(preorder,rootIdx+1,end);

        return root1;
    }
}