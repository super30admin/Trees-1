class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class ValidBST {
        public boolean isValidBST(TreeNode root)
        {
            if(root==null)
            {
                return true;
            }
            return findValidity(root,null,null);
        }
        private boolean findValidity(TreeNode root,Integer min,Integer max)
        {
            if (root==null)
            {
                return true;
            }
            if((min!=null && root.val<=min) || (max!=null && root.val>= max))
            {
                return false;
            }
            return (findValidity(root.left,min, root.val) && findValidity(root.right,root.val, max) );
        }
        public static void main(String[] args) {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);
            ValidBST validBST = new ValidBST();
            System.out.println(validBST.isValidBST(root));
        }
    }

