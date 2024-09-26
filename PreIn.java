// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(1) for recursive solution 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PreIn {
    HashMap<Integer,Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return getRoot(preorder, inorder, 0, preorder.length-1);
    }
    
    private TreeNode getRoot(int[] preorder, int[] inorder, int start, int end)
    {
        if(start>end || index>=preorder.length) return null;
        
        int idx = map.get(preorder[index]);
        TreeNode root = new TreeNode(inorder[idx]);
        index++;
        root.left = getRoot(preorder,inorder,start,idx-1);
        root.right = getRoot(preorder,inorder,idx+1,end);
        return root;
        
    }
}