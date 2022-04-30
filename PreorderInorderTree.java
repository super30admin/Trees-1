// Time Complexity :O(nxn)
// Space Complexity :O(h) - heigth of tree, in worst case O(n) - uses stack memory
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class PreorderInorderTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        
        return helper(preorder, inorder, 0, 0, preorder.length-1);        
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int proot, int left, int right){
        //base
        if(left > right || left < 0 || right >= preorder.length || proot < 0 || proot >= preorder.length) return null;
        
        //logic
        TreeNode node = new TreeNode(preorder[proot]);
        
        //find root in inorder
        int i = 0;
        for(i = left; i <= right; i++){
            if(inorder[i] == preorder[proot]){  
                break;
            }
        }
        //recurse
        node.left = helper(preorder, inorder, proot+1, left, i-1);
        node.right = helper(preorder, inorder, proot+i-left+1, i+1, right);
        return node;
    }
}
