public class ConstructBTPreOrderAndInOrder
    {
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        // Approach: Create a hashmap for all inorder array along with indexes. Start traversing from Preorder array by creating root nodes
        //              Find the root node just created in inorder hashmap and get the index
        //              Everything to the left of the index will be in left substree and right will be right subtree
        //              Recursively call to build left and right subtree for each node in preorder
        
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

        int preOrderIndex = 0;

        public TreeNode BuildTree(int[] preorder, int[] inorder)
        {
            int n = preorder.Length - 1;
            Dictionary<int, int> inOrderMap = new Dictionary<int, int>();
            return helper(preorder, inOrderMap, 0, n);
        }

        public TreeNode helper(int[] preorder, Dictionary<int,int> inOrderMap, int inOrderStart, int inOrderEnd)
        {
            //base case
            if (inOrderStart > inOrderEnd)
                return null;

            int rootElement = preorder[preOrderIndex]; //preorder: root -> left -> right
            preOrderIndex++; //to get the next root

            TreeNode root = new TreeNode(rootElement);

            //logic
            if (inOrderStart == inOrderEnd)
                return root;

            int inOrderIndex = inOrderMap[rootElement]; //inorder: left -> root -> right

            root.left = helper(preorder, inOrderMap, inOrderStart, inOrderIndex - 1);
            //st.pop()
            root.right = helper(preorder, inOrderMap, inOrderIndex + 1, inOrderEnd);
            //st.pop()
            return root;
        }
    }
