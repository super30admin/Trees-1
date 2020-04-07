//105. Construct Binary Tree from Preorder and Inorder Traversal
//Time Complexity: O(n)
//Space Complexity: O(n)



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
        
        if(preorder.length == 0)
            return null;
        HashMap<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i){
            //no duplicates allowed
            inOrderMap.put(inorder[i],i);
        }
        return helper(0, preorder, inorder, 0, inorder.length - 1, inOrderMap);
        
    }
    public TreeNode helper(int preOrderIndex,int[] preorder,int[] inorder,int start,int end, HashMap<Integer, Integer> inOrderMap){
        if(start > end ){
            return null;
        }
        if(start == end)
            return new TreeNode(inorder[start]);
        TreeNode root = new TreeNode(preorder[preOrderIndex]);
        root.left = null;
        root.right = null;
        int inOrderIndex = inOrderMap.get(preorder[preOrderIndex]);
        int leftCount = inOrderIndex - start;
        root.left = helper(preOrderIndex+1, preorder, inorder, start, inOrderIndex-1, inOrderMap);
        root.right = helper(preOrderIndex + leftCount + 1, preorder, inorder, inOrderIndex + 1, end, inOrderMap);
        return root;
    }
}
