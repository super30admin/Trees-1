//TC O(n^2)
//SC O(n^2)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = 0;
        
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val)
                rootIdx = i;
        }
        
        int [] preLeft = Arrays.copyOfRange(preorder,1, rootIdx + 1);
        int [] preRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inRight = Arrays.copyOfRange(inorder,rootIdx + 1, inorder.length);
        
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;     
        
    }
}