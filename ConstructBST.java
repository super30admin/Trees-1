class Solution {
    
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        this.idx = 0;
        return helper(preorder, 0, preorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map){
        // base case
        if(start > end) return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1, map);
        root.right = helper(preorder, rootIdx + 1, end, map);
        
        return root;
    }
}

Time Complexity : O(n)
Space Complexity : O(n)
