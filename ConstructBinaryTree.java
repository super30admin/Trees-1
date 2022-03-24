//Time Complexity O(n)
//Space Complexity O(h)
//Leetcode tested

public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    public TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(preStart>=preorder.length || inStart>inEnd) return null;
        int ind=0;
        TreeNode node = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == node.val)
                ind=i;
        }
        node.left=helper(preStart+1,inStart,ind-1,preorder,inorder);
        node.right=helper(preStart+ind-inStart+1,ind+1,inEnd,preorder,inorder);

        return node;
    }
}
