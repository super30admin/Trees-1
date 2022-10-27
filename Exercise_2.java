class Solution {
    private int i;
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        this.inorder=inorder;
        this.preorder=preorder;
        return buildTree(0, inorder.length-1);
    }
    public TreeNode buildTree(int s, int e){
        if(s>e){
            return null;
        }
        
        TreeNode n = new TreeNode(preorder[i]);
        ++i;
        int ii = search(inorder,s,e,n.val);
        n.left = buildTree(s, ii-1);
        n.right = buildTree(ii+1, e);
        return n;
    }
    private int search(int[] arr,int s,int e,int x){
        for(int y=s;y<=e; ++y){
            if (arr[y]==x){
                return y;
            }
        }
        return -1;
    }
}
//tc = O(n^2);
//sc=O(n)
