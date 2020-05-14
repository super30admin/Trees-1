//Time Complexity : O(n^2) (We can further reduce it by using a hashmap instead of finding the element in inorder array every time
//Space Complexity : O(n) (Height of the tree, in worst case would be n)
//Runs successfully on leetcode
//Problem : No problem

//Here we will be recursively calling the helper function to make the root node and its decendents


public class Trees_1_Problem_2_PreIN {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length - 1,preorder,inorder);
    }
    private TreeNode helper(int preIndex,int inStart,int inEnd,int[] preorder,int[] inorder)
    {
        if(preIndex > preorder.length - 1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex]);

        int index = 0;
        for(int i = inStart ; i <= inEnd ; i ++)
        {
            if(preorder[preIndex] == inorder[i])
            {
                index = i;
            }
        }

        root.left = helper(preIndex + 1, inStart,index - 1,preorder,inorder);
        root.right = helper(preIndex + index - inStart + 1,index + 1,inEnd,preorder,inorder);

        return root;
    }

}
