package BST;

// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes
public class ValidateBSTUsingMInMax {

    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inOrder(root, null, null);
        return flag;
    }

    public void inOrder(TreeNode root, Integer min, Integer max){

        if(root == null) return;

        if(min!=null && root.val <= min)
        {
            flag = false;
        }
        if(max!=null && root.val >= max)
        {
            flag = false;
        }

        if(flag)
            inOrder(root.left, min, root.val);
        if(flag)
            inOrder(root.right, root.val, max);
    }
}

