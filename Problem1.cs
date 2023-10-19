 public class ValidateBST
    {
        // Time Complexity : O(n) - traversing all nodes
        // Space Complexity : O(h) -  where h is the height of the tree and at any point in the recursion stack there will be h function calls
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        bool flag = true;
        TreeNode prev;
        public bool IsValidBST(TreeNode root)
        {
            helperInorder(root);
            return flag;
        }

        public void helperInorder(TreeNode root)
        {
            //Base case
            if (root == null)
                return;

            //logic
            //conditional recursion- stops traversing left nodes
            if (flag)
            {
                helperInorder(root.left);
                //stack.pop()- under the hood
            }

            //Console.WriteLine(root.val);

            if (prev != null && prev.val >= root.val)
            {
                flag = false;
            }

            prev = root;
            //conditional recursion- stops traversing right nodes
            if (flag)
            {
                helperInorder(root.right);
                //stack.pop()
            }

        }
    }
