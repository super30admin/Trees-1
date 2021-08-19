public class Problem1 {
   
        TreeNode prev;
        boolean isValid;
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            isValid = true;
            inorder1(root);
            return isValid;
        }
        private void inorder1(TreeNode root){
            if(root == null){
                return;
            }
            inorder1(root.left);
            if(prev != null && prev.val >= root.val){
                isValid = false;
            }
            prev = root;
            inorder1(root.right);
            //System.out.println("S : " + root.val);
        }
    }