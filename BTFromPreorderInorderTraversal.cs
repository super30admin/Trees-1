//Time Complexity: O(n)
//Space Complexity: O(n)

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
    Dictionary<int,int> map;
    int idx;

    //using dictionary and start and end indexes
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        this.idx = 0;
        this.map = new Dictionary<int,int>();

        for(int i=0; i< inorder.Length; i++){
            map.Add(inorder[i],i);
        }

        return helper(preorder, 0, inorder.Length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start>end) return null;

        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map[rootVal];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start,rootIdx-1);
        root.right = helper(preorder,rootIdx+1, end);

        return root;
    }

}
