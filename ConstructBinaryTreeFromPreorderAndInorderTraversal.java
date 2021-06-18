// Time complexity: O(N)
// Space complexity: O(N)
// Run on leetcode: Yes
// Issues: couldn't come up with the base case

class Solution {
    int index;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.index = 0;
        this.map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[]preorder, int start, int end){
        // base
        if(start > end)
            return null;
        
        //logic
        TreeNode root = new TreeNode(preorder[index]);
        int p = map.get(root.val);
        index++;
        root.left = helper(preorder, start, p-1);
        root.right = helper(preorder, p+1, end);
        return root;
    }
}
