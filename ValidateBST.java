//TimeComplexity=O(n)
//Space Complexity=O(1);
public class ValidateBST {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode prev;


    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);
    }

    private boolean helper(TreeNode root,Integer min,Integer max){
        if(root==null) return true;

        if(min!=null && min>=root.val){
            return false;
        }
        if(max!=null && max<=root.val){
            return false;
        }


        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}

