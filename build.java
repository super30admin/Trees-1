//Time Complexity:O(number of nodes)
//space Complexity:O(height of tree)

class TreeNode {
         int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;    
    }   
}
public class build {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int cnt = 0;
        for(int i = inStart; i <= inEnd && inorder[i] != root.val; i++) {
            cnt++;
        }
        root.left = helper(preorder, inorder, preStart+1, preStart+cnt, inStart, inStart+cnt-1);
        root.right = helper(preorder, inorder, preStart+cnt+1, preEnd, inStart+cnt+1, inEnd);
        return root;
    }
    
}
