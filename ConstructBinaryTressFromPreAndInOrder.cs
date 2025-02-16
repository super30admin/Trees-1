// time complexity O(n)
// space complexity O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int rootIdx = 0;
    Dictionary<int,int> inorderDict;
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        inorderDict =  new Dictionary<int,int>();
        for(int i=0;i<inorder.Length;i++)
        {   
            inorderDict.Add(inorder[i],i);
        }
        return helper(preorder, 0, inorder.Length-1);
    }

    public TreeNode helper(int[] preorder, int left, int right)
    {   
        // base
        if(left>right)
        {
            return null;
        }
        // logic
        int rootVal = preorder[rootIdx];  
        TreeNode root  = new TreeNode(rootVal);      
        rootIdx++;

        int inIdx = inorderDict[rootVal];
        
        // left
        root.left = helper(preorder, left, inIdx-1);
        // right
        root.right = helper(preorder, inIdx+1, right);

        return root;
    }
    // public int[] CopyOfRange(int[] nums, int from, int to)
    // {
    //     int le = to -from;
    //     int[] res = new int[le];
    //     Array.Copy(nums, from, res, 0 , le);
    //     return res;
    // }
}