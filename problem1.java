package Trees-1;

public class problem1 {

    //TC:- O(n)
    //SC:- O(h)
    class Solution {
        int x=0;
        int prev = Integer.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
             if(root.left == null && root.right == null) {return true;}
            return helper(root);
        }
        public boolean helper(TreeNode root){
            if(root == null) return true;
           
            
           boolean left =  helper(root.left);
            if( x==1 && prev >= root.val){
                return false;
            }
            prev = root.val;
            x=1;
            boolean right = helper(root.right);
            
            return left && right;
        }
    }
}