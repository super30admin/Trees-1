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
    int preIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        //maintain map of indexes for inOrder
        inorderIndexMap = new HashMap<>();
        
        for(int i=0; i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0 ,preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        //first node is always root in preorder, get that value and construct tree
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        //next we limit our view to (left, current index - 1)
        // these indices in preorder will be our left subtree of root 
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
        
        //similarly for right subtree (current index + 1, right)
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootVal)+1, right);
        
        return root;
    }
}