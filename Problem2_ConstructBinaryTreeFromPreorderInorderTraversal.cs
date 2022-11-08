// Approach : preorder is in the order NLR(Node->left->Right) and inorder traversal is in the order (Left->Node->Right). So the first element in the preorder is our root node and anything left to this root in inorder would the left subtree and anything right would be the right subtree
// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) for the reursion stack space where h is the height of the tree. h ranges from "log n" in best case when tree is balanced to "n" in worst case when the tree i fully skewed. 
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
    int[] inorder;
    int[] preorder;
    int preIndex;
    Dictionary<int, int> inorderIndices;
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        
        inorderIndices = new Dictionary<int, int>();
        
        for(int i=0; i<inorder.Length; i++){
            inorderIndices.Add(inorder[i], i);
        }
        
        return BuildTree( 0, inorder.Length-1);
    }
    
    public TreeNode BuildTree(int inLow, int inHigh){
        //base
        if(preIndex == preorder.Length || inLow >inHigh) return null;
        
        //process
        int nodeval = preorder[preIndex];
        TreeNode node = new TreeNode(nodeval);
        int inIndex = inorderIndices[nodeval];
        preIndex++;
        
        //recurse
        node.left = BuildTree(inLow, inIndex-1);
        node.right = BuildTree(inIndex+1, inHigh);
            
        return node;
    }
}