//space complexity: O(height) //max elements in the recursive stack
//Time complexity : O(N) , n are the nodes

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


class Problem1 {
    //taking it global so that value changes
    TreeNode prev;

    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;

        //a valid BST would have a sorted inorder traversal
        //root should be greater than the previous element
        inorder(root);

        return flag;


    }
    private void inorder(TreeNode root){
        if (root==null) return;

        if(flag)
            inorder(root.left);
        //stack.pop() takes place = root
        //System.out.print("up");
        //System.out.println(root.val);

        if(prev!=null && prev.val >= root.val){
            flag = false;
            //optimizing

        }

        //updating the prev
        prev = root;

        //if flag is true, then making the right call
        if(flag)
            inorder(root.right);
        //stack.pop()
        //System.out.print("down");
        //System.out.println(root.val);


    }
}