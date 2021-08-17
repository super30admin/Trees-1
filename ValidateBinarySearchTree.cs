using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class ValidateBinarySearchTreeLC
    {
        //Time Complexity: O(n)
        //Space Complexity: O(h)
        //Definition for a binary tree node.
        public class TreeNode
        {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        TreeNode prev;
        bool IsValid;
        public bool IsValidBST(TreeNode root)
        {
            if (root == null)
            {
                return true;
            }
            IsValid = true;
            inorder(root); //recursive
            //return inorderWithMinMax(root, null, null);
            //IsValidBSTIteration(root); // iterative
            return IsValid;
        }

        private void inorder(TreeNode root)
        {
            //base
            if (root == null)
            {
                return;
            }
            inorder(root.left);
            if (prev != null && prev.val >= root.val)
            {
                IsValid = false;
                //return; for optimization
            }
            Console.WriteLine("root:" + root.val);
            if (prev != null)
            {
                Console.WriteLine("prev:" + prev.val);
            }
            prev = root;
            inorder(root.right);
        }

        private bool inorderWithMinMax(TreeNode root, int min, int max)
        {
            //base
            if (root == null)
            {
                return true;
            }
            if (inorderWithMinMax(root.left, min, root.val) == false)
            {
                return false;
            }
            if ((min != null && root.val <= min) || (max != null && root.val >= max))
            {
                return false;
            }

            return inorderWithMinMax(root.right, root.val, max);
            //return inorderWithMinMax(root.left, min, root.val) && inorderWithMinMax(root.right, root.val, max);
        }
        private bool inorderWithReturn(TreeNode root)
        {
            //base
            if (root == null)
            {
                return true;
            }
            if (inorderWithReturn(root.left) == false)
            {
                return false;
            }
            if (prev != null && prev.val >= root.val)
            {
                return false;
            }
            prev = root;
            return inorderWithReturn(root.right);
        }
    
        private void IsValidBSTIteration(TreeNode root)
        {
            Stack<TreeNode> s = new Stack<TreeNode>();
            while (root != null || s.Count != 0)
            {
                while (root != null)
                {
                    s.Push(root);
                    root = root.left;
                }
                root = s.Pop();
                if (prev != null && prev.val >= root.val)
                {
                    IsValid = false;
                    break;
                }
                prev = root;
                root = root.right;
            }
        }

        public void ReadBinarySearchTree(TreeNode root)
        {
            if (root == null)
            {
                return;
            }
            inorderForRead(root);
        }

        private void inorderForRead(TreeNode root)
        {
            if (root == null)
            {
                return;
            }
            inorderForRead(root.left);
            //s.pop();
            Console.WriteLine("F: " + root.val);
            inorderForRead(root.right);
            Console.WriteLine("S: " + root.val);
        }
        public void ReadBinaryTreeIteration(TreeNode root)
        {
            Stack<TreeNode> s = new Stack<TreeNode>();
            while (root != null || s.Count != 0)
            {
                while (root != null)
                {
                    s.Push(root);
                    root = root.left;
                }
                root = s.Pop();
                Console.WriteLine(root.val);
                root = root.right;
            }
        }
    }
}
