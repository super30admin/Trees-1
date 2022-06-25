/*This code utilizes recursion to build the binary tree. It finds the root element from the 
preorder array, and finds its location in the inorder array. In the inorder array, everything
to the left of the root will be the left subtree, and everything to the right of the root will
be the right subtree. Using this information, we recursively compute upon the preorder array,
and build the tree

Did this code run on leetcode: Yes
*/
class Solution {
    HashMap<Integer, Integer> map;
    //Since root is at the start of preorder, we start from the front
    int idx = 0;
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {   //We use a hash map to store the indices of the values of the inorder array so that our search can be more optimisied
        map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end)
    {   
        if(start > end)
            return null;
        
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        //In the preorder array, all the root nodes will be in increasing order
        idx++;

        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }
}