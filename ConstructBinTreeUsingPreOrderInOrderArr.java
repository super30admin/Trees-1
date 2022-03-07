// Time Complexity : O(n) using hashmap else O(n^2) without HashMap; for every node we are checking in order position and then doing.
// Space Complexity : O(1) if recursion ignore but if so then ~ Implicit stack O(H); if tree is skewed
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/652822002/)
// Any problem you faced while coding this : No
// My Notes : Approach 1 : visit the nodes in the preorder and split the inorders
class Solution {
    // Created hashmap to store the inorder index position to retreive in constant time
    private HashMap<Integer, Integer> map = new HashMap<>();
    // Increment preorder idex of node after creating the node
    private int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create hashmap tp get the index position of the inorder element.
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        //System.out.println(" Map : "+map);
        
        return buildTree(preorder, 0, preorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int left, int right){
        // if left child is left,right is 0,0 then left, right node will be 0,-1 & 1,0 where it will break and the children would be null with only node created.
        if(left>right){
            return null;
        }
        // Create node from the preorder
        TreeNode root = new TreeNode(preorder[preIdx]);
        // Increment node after creating the root node
        preIdx++;
        int currInordIdx = map.get(root.val);
        // left node range from start till the idx-1
        root.left = buildTree(preorder, left, currInordIdx - 1);
        // right subtree range from idx+1 till the end
        root.right = buildTree(preorder, currInordIdx+1, right);
        return root;
    }
}