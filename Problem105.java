// Time Complexity : O(n) -- no.of nodes in BST
// Space Complexity :  O(n) -- HashMap space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    HashMap<Integer, Integer> map ;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map= new HashMap<>();
        this.idx=0;
        for(int i=0; i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        // base case
        if(start> end) return null;
        //logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx= map.get(rootVal);
        root.left =  helper(preorder, inorder, start, rootIdx-1);
        root.right =  helper(preorder, inorder,rootIdx+1, end);
        return root;
    }
}