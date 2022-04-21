using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class ValidateBinarySearchTree
    {
        /*
         * T.C: O(N) traversing through all nodes in tree
         * S.C: O(h) where h is hight of tree, as only hight of tree element presnt in the stack at a time.
         */
        public bool IsValidBST(TreeNode root)
        {
            if (root == null) return false;
            TreeNode prev = null;
            Stack<TreeNode> stk = new Stack<TreeNode>();

            while (root != null || stk.Count != 0)
            {
                while (root != null)
                {
                    stk.Push(root);
                    root = root.left;
                }

                root = stk.Pop();

                if (prev != null && prev.val >= root.val)
                    return false;

                prev = root;

                root = root.right;
            }

            return true;
        }


        TreeNode prev = null;
        bool isValid = true;

        //Recursive method
        public bool IsValidBSTRec(TreeNode root)
        {
            InOrderTraverse(root);
            return isValid;
        }

        private void InOrderTraverse(TreeNode root)
        {
            if (root == null) return;

            InOrderTraverse(root.left);
            if (prev != null && prev.val >= root.val)
            {
                isValid = false;
            }

            prev = root;
            InOrderTraverse(root.right);
        }
    }
}
}
