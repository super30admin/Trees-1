//leetcode.com/problems/k-diff-pairs-in-an-array/
// Time Complexity :O(n) -> number of elements
// Space Complexity :1
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes
//      Couldn'' figure out algorithm for all edge cases.
// Your code here along with comments explaining your approach
// 1. used lower and higher variables to check limits for a number in the left or right subtree accordingly
// 2. check if left subtree is valid and then check right subtree recursively and update lower and higher for each recursive subtree.
public class validBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    int head;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        head = root.val;
        int lower = Integer.MIN_VALUE;
        int upper = Integer.MAX_VALUE;
        return helper(root,lower,upper);
    }

    public boolean helper(TreeNode root,int lower,int upper){
        if(root == null)    return true;
        boolean b = true;
        if(root.left!=null){
            if(root.val<=root.left.val )
                return false;
            else{
                upper = root.val;
                if(root.val>lower && root.left.val<=lower)
                    return false;
                else{
                    b = helper(root.left,lower,upper);
                }

            }

        }
        if(b==false) return false;
        if(root.right!=null){
            if(root.val>=root.right.val)
                return false;
            else{
                if(root.val<upper && root.right.val>=upper)
                    return false;
                else{
                    lower = root.val;
                    b = helper(root.right,lower,upper);
                }

            }
        }
        return b;
    }

    public static void main(String[] args) {
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(1);
        input.right = new TreeNode(5);
        input.left.left = new TreeNode(0);
        input.left.right = new TreeNode(2);
        input.right.left = new TreeNode(4);
        input.right.right = new TreeNode(6);
        input.left.right.right = new TreeNode(3);
        validBST obj = new validBST();
        System.out.print(obj.isValidBST(input));
    }
}
