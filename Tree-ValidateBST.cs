using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(N) 
    // Space Complexity :O(H) - height of tree
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Based on class
    public class Tree_ValidateBST
    {
        //recusion (range)
        public bool IsValidBST(TreeNode root)
        {
            return validate(root, null, null);
        }

        private bool validate(TreeNode root, int? low, int? high)
        {
            if (root == null) return true;

            if ((low != null && root.val <= low) || (high != null && high <= root.val))
            {
                return false;
            }
            return validate(root.left, low, root.val) &&
            validate(root.right, root.val, high);

        }


        //iterative
        public bool IsValidBSTIterative(TreeNode root)
        {
            Stack<TreeNode> st = new Stack<TreeNode>();
            TreeNode prev = null;
            while (root != null || st.Count != 0)
            {
                while (root != null)
                {
                    st.Push(root);
                    root = root.left;
                }
                root = st.Pop();
                if (prev != null && prev.val >= root.val)
                {
                    return false;
                }
                prev = root;
                root = root.right;

            }
            return true;
        }
    }
}
