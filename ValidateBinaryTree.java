// take the prev node and iterate through the array.
// Time complexity = O(n). all nodes are traversed.
// space complexity = O(h), where h is the height. worst case h =n , avg case h = log(n) 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ValidateBinaryTree {
    TreeNode prev = null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        helper(root); //new TreeNode(0));
        return flag;
    }
    

    private void helper(TreeNode root) {

        if(root == null) return;
        helper(root.left);
        System.out.println("Root is " + root.val);
        if(prev != null)
            System.out.println(" Prev is " + prev.val);
        
        
        if(prev != null  && prev.val >= root.val) {
            flag = false;
        }
        prev =root;
        helper(root.right);
    }
  

/**
    private boolean helper(TreeNode root) {
        if(root==null) {
            return true;
        }
        boolean left = helper(root.left);
        System.out.println(root.val);

        if(prev!= null && prev.val >= root.val) {
            return false;
        }
        boolean right = true;
        if(left) {
            prev = root;
            right = helper(root.right);                
        }
        return left && right;
    }
**/

/**
    private boolean helper(TreeNode root) {
        if(root==null) {
            return true;
        }
        System.out.println(root.val);
        boolean right = true;
        if(helper(root.left)== false) {
            return false;
        }
        if(prev!= null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        right = helper(root.right);                            

        return right;
    }
    **/
/**    
    private void helper(TreeNode root, TreeNode prev) {
        // the condition to check (flag)
        if(root== null) return;

        helper(root.left, prev);
                System.out.println("root is " + root.val);
        System.out.println("prev is " + prev.val);

        if(prev != null  && prev.val >= root.val) {
            flag = false;
        }
        prev =root;
        helper(root.right, prev);
    }
    **/
}