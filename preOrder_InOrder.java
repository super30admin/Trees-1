class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null case
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        
        //find the root in inorder
        int index = -1;
        for(int i=0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }              
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder ,0, index);
        int[] preLeft = Arrays.copyOfRange(preorder ,1, inLeft.length+1);
        int[] inRight = Arrays.copyOfRange(inorder ,index+1, inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder ,inLeft.length+1, preorder.length);
        
        //recurse
        root.left = buildTree( preLeft, inLeft);
        root.right = buildTree( preRight, inRight);
        
        return root;
    }
}
