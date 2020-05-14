//Time Complexity : O(n) (As we will be iterating through each nodes)
//Space Complexity : O(h) (where h = height of the tree)
//Runs Successfully on leetcode
//No Problem

//Here we will try to iterate through each of the nodes in an inOrder manner
//BST iteration in inOrder manner will always give elements in an ascending order.
//We will compare the element with the previous elements for checking if the element are in ascending order, if not we will return false



import java.util.Stack;



public class Trees_1_Problem_1_validateBST {
    public boolean isValidBST3(TreeNode root) {
        return helper(root, null,null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max)
    {
        if(root == null) return true;
        if((max!=null && root.val >= max) || (min!=null && root.val <= min) )return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }

    TreeNode prev = null;
    public boolean isValidBST2(TreeNode root) {
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root)
    {
        if(root == null) return true;
        if(inOrder(root.left)==false) return false;
        if(prev!=null && prev.val >= root.val) return false;
        prev = root;
        return inOrder(root.right);
    }



    public boolean isValidBST1(TreeNode root) {
        TreeNode prev = null;
        if(root==null) return true;
        Stack<TreeNode> st = new Stack<TreeNode>();

        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val)
            {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

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

