/**
Time complexity: O(N) where N is length of inorder and preorder
Space complexity: O(N) auxilliary space for hashmap and O(H) stack space where H is height of the tree

Algorithm:
=========
1. We have 2 arrays, inorder and preorder. Build a map of (value, index) from inorder array
2. Basic idea is that in preorder, root comes first, so find root index in inorder array
3. Now, start to inIdx-1 is left subtree and inIndx+1 to end is right subtree
4. Construct a binary tree out of this by doing the same steps recursively
*/
class Solution {
    Map<Integer, Integer> map;
    int preidx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preidx = 0;
        map = new HashMap<>();                      // Map of (Value, index) of inorder for O(1) search         
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        
        
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        //base
        if(start > end) return null;
        //logic
        TreeNode root = new TreeNode(preorder[preidx++]);       // keep track of preorder subtree root index
        int inidx = map.get(root.val);                          // find index of root in inorder using map
        root.left = helper(preorder, inorder, start, inidx-1);  // call buildTree recursively on left subtree 
        root.right = helper(preorder, inorder, inidx+1, end);   // call buildTree recursively on right subtree 
        
        return root;
    }
}