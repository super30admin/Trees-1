Time Complexity: O(n)
Space Complexity: O(n)
Ran successfully on leetcode?: Yes

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 || inorder.length == 0) return null;
        
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                index = i;
            }
        }
        
        TreeNode node = new TreeNode(preorder[0]);
        
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
        int[] preorder_left = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] inorder_right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preorder_right = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        
        node.left = buildTree(preorder_left, inorder_left);
        node.right = buildTree(preorder_right, inorder_right);
        
        return node;
    }
}
