using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
        }

        // Time Complexity O(N) where N is the total number of nodes
        // Space Complexity O(h) where h is the height of the tree
        public bool IsValidBST(TreeNode root) {
            return helper1(root, null, null);
        }
        public bool helper1(TreeNode root, int? min, int? max){
            if(root == null) return true;
            if((min != null && root.val <= min) || (max != null && root.val >=max)) return false;
            return helper1(root.left,min,root.val) && helper1(root.right,root.val, max);
        }

        // Time Complexity O(N + k) where N is the total number of nodes including nulls, and k length of preorder (dictionary)
        // Space Complexity O(k+h) where h is the height of the tree
        int[] preorder;
        int[] inorder;
        Dictionary<int, int> dict = new Dictionary<int,int>();
        public TreeNode BuildTree(int[] preorder, int[] inorder) {
            for(int i = 0; i<inorder.Length; i++) dict.Add(inorder[i], i);
            this.preorder = preorder;
            this.inorder = inorder;
            return helper(0,preorder.Length-1, 0);        
        }
        public TreeNode helper(int start1, int end1, int start2){
            if(start1 > end1) return null;
            TreeNode res = new TreeNode(preorder[start1]);
            int idx = dict[preorder[start1]];
            res.left = helper(start1+1, start1+idx-start2, start2);
            res.right = helper(start1+idx-start2 +1, end1, idx+1);
            return res;
        }        
    }
}
