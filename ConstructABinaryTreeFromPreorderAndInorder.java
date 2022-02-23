/*
Time Complexity: O(n)
Space Complexity: O(n)
Code run on leetcode: Yes
Any difficulties: no

Approach:
Recursion

 */
public class ConstructABinaryTreeFromPreorderAndInorder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructBSTInPre(preorder, inorder, 0, inorder.length-1, 0);
    }
    public static TreeNode constructBSTInPre(int[] preorder, int[] inorder, int start, int end, int index){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);

        int inStartIndex = start;
        while(preorder[index]!= inorder[inStartIndex]){
            inStartIndex++;
        }
        root.left = constructBSTInPre(preorder, inorder, start, inStartIndex-1, index+1);
        root.right = constructBSTInPre(preorder,inorder, inStartIndex+1, end, index+inStartIndex-start+1);
        return root;
    }

    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder,inorder);
    }
}
