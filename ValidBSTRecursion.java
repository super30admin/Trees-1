package Trees1;

/* Time complexity : o(n) - n is the number of elements in tree
   space complexity: o(h) - Height of the tree. At any given time,there will H nodes inside my recursive stack.
   Did this code run successfully in leetcode : yes
   problems faces : no
        */

public class ValidBSTRecursion {

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {

        return inorder(root);
    }

    public  boolean inorder(TreeNode root)
            {
                //base
                    if(root == null) return true;
                    if(inorder(root.left) == false) return false;    
                    System.out.println(root);
                    if (prev != null && prev.val >= root.val)  return false;
                    prev = root;

                   return  inorder(root.right);
            }


    public class TreeNode {
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

}