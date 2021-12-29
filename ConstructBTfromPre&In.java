//Time complexity : O(n)
//Space complexity : O(n)
// leetcode: success
class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int inorderIndex = 0;
        
        for(int i = 0 ; i < inorder.length ; i++){         
            if(inorder[i] == root.val){
                inorderIndex = i;
                break;
            }
        }
        
        int[] leftpreOrderArray = Arrays.copyOfRange(preorder,1,inorderIndex+1);
        int[] leftinOrderArray = Arrays.copyOfRange(inorder,0,inorderIndex+1);
        
        int[] rightpreOrderArray = Arrays.copyOfRange(preorder,inorderIndex+1,preorder.length);
        int[] rightinOrderArray = Arrays.copyOfRange(inorder,inorderIndex+1,inorder.length);
        
        root.left = buildTree(leftpreOrderArray,leftinOrderArray);
        root.right = buildTree(rightpreOrderArray,rightinOrderArray);
        
        return root;
    }
    
}