class Solution {
    public TreeNode createTree(int []preorder,HashMap<Integer,Integer> ans,int idx,int left,int right){
        TreeNode root = new TreeNode(preorder[idx]);
        int mid = ans.get(preorder[idx]);
        if(left<mid){
            root.left = createTree(preorder,ans,idx+1,left,mid-1);
        }
        if(right>mid){
            root.right = createTree(preorder,ans,idx+mid-left+1,mid+1,right);
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(preorder,map,0,0,inorder.length-1);

    }
}
