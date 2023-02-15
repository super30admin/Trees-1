// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I stored the values of inorder along with the index at which it appears in a map. I obtain the root node as preorder[index] and rootIndex as the position at which it is present in the inorder
 * list.I recurisvely call root.left with left index as the same and right index as rootIndex-1 and root.right with right index as the same and left index as root to generate the tree. 
 */

class Solution2 {
    HashMap<Integer,Integer> map;
    int index=0;
    public TreeNode generate(int l, int r,int []preorder)
    {
        if(l>r)
        {
            return null;
        }
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left=generate(l,rootIndex-1,preorder);
        root.right=generate(rootIndex+1,r,preorder);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return generate(0,inorder.length-1,preorder);
    }
}