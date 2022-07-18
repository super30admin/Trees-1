//Time Complexity : O(n^2)
//Space Complexity : O(n*h), where h is the height of the tree.
//Code run successfully on LeetCode.

public class Problem2_1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        
        int rootIdx = -1;
        int rootVal = preorder[0];
        
        TreeNode root = new TreeNode(rootVal);
        
        for(int i =0; i < inorder.length; i++){
            if(inorder[i] == rootVal)
            {
                rootIdx = i;
                break;
            }
        }
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx +1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx +1, preorder.length);
        
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }
}
