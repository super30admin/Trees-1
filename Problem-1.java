// Time Compelxity: O(n)
// Space: O(h) = O(n) in worst case if tree is skewed else o(log(n))

import javax.swing.tree.TreeNode;

//Solution1: boolean recursion using previous node value
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root){
        if(root == null) return true;
        boolean left = inOrder(root.left);
        if(prev != null && prev.val>= root.val){
            return false;
        }
        prev = root;
        boolean right = inOrder(root.right);

        return left && right;

    }
}

//Solution2 : boolean recursion using min and max range
//min remains same for left and max remains same for right subtree
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root, null, null);
    }

    private boolean inOrder(TreeNode root, Integer min, Integer max){
        if(root == null) return true;


        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;

        boolean left = inOrder(root.left, min, root.val);
        boolean right = false;;
        if(left){
            right = inOrder(root.right, root.val, max);
        }

        return right;

    }
}

//Solution3: void based recursion
class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }
      private void inorder(TreeNode root){
        // base
        if(root == null) return;
        System.out.println(root.val);
        inorder(root.left);
        //st.pop();
        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        inorder(root.right);
        //st.pop();
    }
}