class Solution {
    // Time complexity: O(n)
    // Space complexty: O(n)
    
    // Strategy: 
    // 1. we could treat each element in preorder as root value;
    // 2. interms of the root value obtained before, we can locate it in the inorder array, and the left part of this array could be treated as left subtree and the right part of this array could be treated as right subtree.
    // 3. then, recursively divide the left subtree and right subtree to build the binary tree.
    
    Map<Integer, Integer> map;
    int pre_idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int left, int right){
        // base case
        if(left > right){
            return null;
        }
        int root_val = preorder[pre_idx++];
        // locate the index of root to divide the binary tree into left subtree and right subtree
        int inorder_idx = map.get(root_val);
        TreeNode cur = new TreeNode(root_val);
        // traverse left part
        cur.left = buildTree(preorder, inorder, left, inorder_idx - 1);
        // traverse right part
        cur.right = buildTree(preorder, inorder, inorder_idx + 1, right);
        return cur;
    }
}