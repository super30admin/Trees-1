// class Solution {
//     TreeNode prev;
//     boolean flag;
//     public boolean isValidBST(TreeNode root) {
//         this.flag = true;
//         helper(root);
//         return flag;  
//     }

//     private void helper(TreeNode root) {
//         // base case
//         if(root == null ) return;

//         if(flag)
//         helper(root.left);

//         System.out.println(root.val);
//         if(prev!= null && prev.val >= root.val) {
//             flag = false;
//             return;
//         }

//         prev = root;
//         if(flag)
//         helper(root.right);

//     }
// }

//TC:- O(N)
//SC:- O(h)

class ValidateBST {

    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        helper(root, null, null);
        return flag;
       
    }

    private void helper(TreeNode root, Integer min, Integer max) { // since we need infinity values, we cannot use int and have to use Integer.
        if(root == null) return;

        // pre-order manner
        if(min !=null && root.val <= min) {
            flag = false;
        }

        if(max !=null && root.val >= max) {
            flag = false;
        }

        helper(root.left, min, root.val);

        helper(root.right, root.val, max);
       

    }
}