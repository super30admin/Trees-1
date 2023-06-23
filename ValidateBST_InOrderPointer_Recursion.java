public class ValidateBST_InOrderPointer_Recursion {

    class Solution {

        boolean flag;

        TreeNode prev;

        public boolean isValidBST(TreeNode root) {

            flag = true;

            inorder(root);

            return flag;

        }

        private void inorder(TreeNode root){

            //base
            if( root == null ) return;

            //if(!flag) return;

            //logic
            if(flag){
                inorder(root.left);
            }

            System.out.println(root.val);
            if(prev != null && prev.val >= root.val) {

                flag = false;
            }
            prev = root;

            if(flag){
                inorder(root.right);
            }
        }
    }
}
