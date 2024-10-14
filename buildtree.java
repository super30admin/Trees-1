class Solution {
    HashMap <Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx=0;
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int [] preorder, int start, int end){
        if(start>end) return null;

        TreeNode root=new TreeNode(preorder[idx++]);
        int rootidx = map.get(root.val);
        root.left = helper(preorder,start,rootidx-1);
        root.right = helper(preorder, rootidx+1, end);
        return root;
    }
}
