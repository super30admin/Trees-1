// Time Complexity: O(n)
// Space Complexity: O(n)

class PreInBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1);
    }
    int preInd=0;
    public TreeNode helper(int[] preorder,int[] inorder,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preInd++]);
        int i;
        for(i=start;i<=end;i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        root.left=helper(preorder,inorder,start,i-1);
        root.right=helper(preorder,inorder,i+1,end);
        return root;
    }
}