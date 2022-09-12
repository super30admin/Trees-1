/* 
Time Complexity: O(2*n where n is the height of the tree)
Space Complexity: O(n) for stack calls worst case
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return rBuildTree(preorder,0,n-1,inorder,0,n-1);
    }

    private TreeNode rBuildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(isi>iei)
            return null;
        int idx = isi;
        while(inorder[idx]!=preorder[psi])
            idx++;
        
        int colse = idx-isi;
        TreeNode node = new TreeNode(preorder[psi]);
        
        node.left = rBuildTree(preorder,psi+1,psi+colse,inorder,isi,idx-1); // left subtree call
        node.right = rBuildTree(preorder,psi+colse+1,pei,inorder,idx+1,iei); // right subtree call
            
        return node;
    }
}