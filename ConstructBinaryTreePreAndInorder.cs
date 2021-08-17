using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class ConstructBTFromPreAndInOrder
    {
        //Time Complexity: O(n)
        //Space Complexity: O(h)
         //Definition for a binary tree node.
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            public TreeNode() { }
            public TreeNode(int val) { this.val = val; }
            public TreeNode(int val, TreeNode left, TreeNode right)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        Dictionary<int, int> map;
        int idx;
        public TreeNode BuildTree(int[] preorder, int[] inorder)
        {
            if (preorder == null || preorder.Length == 0)
            {
                return null;
            }
            map = new Dictionary<int, int>();
            for (int i = 0; i < inorder.Length; i++)
            {
                map.Add(inorder[i], i);
            }
            return helper(preorder, inorder, 0, preorder.Length - 1);
        }

        private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
        {
            //base
            if (start > end)
            {
                return null;
            }
            //logic
            int rootVal = preorder[idx];
            idx++;
            TreeNode root = new TreeNode(rootVal);
            int rootIdx = map[rootVal];
            root.left = helper(preorder, inorder, start, rootIdx - 1);
            root.right = helper(preorder, inorder, rootIdx + 1, end);
            return root;
        }
        public TreeNode BuildTreeBruteForce(int[] preorder, int[] inorder)
        {
            if (preorder == null || preorder.Length == 0)
            {
                return null;
            }
            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);
            int index = -1;
            for (int i = 0; i < inorder.Length; i++)
            {
                if (rootVal == inorder[i])
                {
                    index = i;
                    break;
                }
            }
            int c = 0;
            int[] inorderLeft = null;//end is not included
            int[] inorderRight=null;
            int[] preorderLeft = null;
            int[] preorderRight=null;
            for (int i = 0; i< index; i++) {
                inorderLeft[c] = inorder[i];
                c++;
            }
            c = 0;
            for (int i = index + 1; i < inorder.Length; i++)
            {
                inorderRight[c] = inorder[i];
                c++;
            }
            c = 0;
            for (int i = 1; i < index + 1; i++)
            {
                preorderLeft[c] = preorder[i];
                c++;
            }
            c = 0;
            for (int i = index + 1; i < preorder.Length; i++)
            {
                preorderRight[c] = preorder[i];
                c++;
            }
            root.left = BuildTree(preorderLeft, inorderLeft);
            root.right = BuildTree(preorderRight, inorderRight);
            return root;
        }
    }
}
