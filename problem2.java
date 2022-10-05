package Trees-1;

public class problem2 {
    //TC:- O(n)
    //SC:- O(h)
    class Solution {
        int pt = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder == null || preorder.length == 0 || inorder.length == 0) return null;
            
            return helper(preorder, inorder, 0, inorder.length-1);
        }
        
        public TreeNode helper(int[] preorder, int[] inorder, int l, int r){
            if(r < l) return null;
            if(pt>preorder.length-1) return null;
            
            TreeNode node = new TreeNode(preorder[pt]);
            
            int x = 0;
            for(int i=0; i<inorder.length; i++){
               if(preorder[pt] == inorder[i])
               {x = i;}
            }
            pt++;
            
            node.left = helper(preorder, inorder, l, x-1);
            node.right = helper(preorder, inorder, x+1, r);
            
            return node;
        }
    }
}
