// Time Complexity : O(n) where n is total nodes in the tree
// Space Complexity : O(n) where n is total nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class ConstructTree {
    
    Map<Integer, Integer> map;
    int index;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap();
        for(int i=0; i<inorder.length;i++) map.put(inorder[i], i);
        return dfs(preorder, 0, preorder.length-1);
    }
    
    private TreeNode  dfs(int[] preorder, int start, int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int idx = map.get(root.val);
        
        root.left = dfs(preorder, start, idx-1);
        root.right = dfs(preorder, idx+1, end);
        
        return root;
    }
}