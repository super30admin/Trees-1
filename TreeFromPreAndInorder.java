/** SC O(H) - wheere H is the height f the tree , TC - O(N)
 * Ran on leetcode - yes
*/
class Solution {
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null; 
        if (preorder.length ==0) return null;
        int start = preorder[0];
        for (int i = 0 ; i < inorder.length; i++){
            if (inorder[i] == start){
                  idx = i;
            }

        }

        root = new TreeNode(inorder[idx]);
        int[] newInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] newInorder2 = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] subleftpre  = Arrays.copyOfRange(preorder,1,idx+1);
        int[] subrightpre = Arrays.copyOfRange(preorder,idx+1,preorder.length);
        root.left = buildTree(subleftpre, newInorder);
        root.right = buildTree(subrightpre,newInorder2);
        
        return root;
        
    }
}
