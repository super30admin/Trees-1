//Time Complexity: O(n)
//Space Complexity: O(1)

class validateBST {
    boolean flag = true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root!= null){
            helper(root);
        }
        return flag;
    }
    public void helper (TreeNode root){
        if(root.left!=null){
            helper(root.left);
        }
        if(prev!=null){
            if(prev.val>=root.val){
                flag = false;
                return;
            }
        }
       
        prev = root;
        // System.out.println(prev.val);
        if(root.right!= null){
            helper(root.right);
        }
    }
}