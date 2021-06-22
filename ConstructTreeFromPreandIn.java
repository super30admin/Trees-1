// Time Complexity :  O(N^2)
// Space Complexity : O(N^2)


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        
        int index = -1;
        for(int i = 0; i < inorder.length; i++){// find the root location
           if(inorder[i]==root.val){
               index=i;
               break;
           }    
        }
        int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index + 1);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left=buildTree(leftPre, leftIn);
        root.right=buildTree(rightPre,rightIn);
        
        return root;
    }
}