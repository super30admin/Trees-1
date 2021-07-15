//Time Complexity: O(n*n)
//Space Complexity: O(n*n)
class Solution {
    int rootIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder ==null || preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<inorder.length;i++){
            if(preorder[0] == inorder[i]){
                rootIndex=i;
            }
        }

        int[] preleft = Arrays.copyOfRange(preorder,1,rootIndex+1);
        int[] preRight = Arrays.copyOfRange(preorder,rootIndex+1,preorder.length);
        int[] inleft = Arrays.copyOfRange(inorder,0,rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);

        root.left = buildTree( preleft,inleft);
        root.right = buildTree(preRight,inRight);
        return root;
    }
}