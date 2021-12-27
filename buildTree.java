// Time Complexity :O(n)
// Space Complexity : O(n)(hashmap)+O(H)(recursive stack)-->O(n) Asymptotic
// Did this code successfully run on Leetcode 105: yes
/* we can find the root from the preorder array as it is the first element present; then we can find the
 position of root element in the inorder array; the element towards the left in the order contribute to
 the left subtree and the elements to the right of the root in inorder contribute to the right subtree */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx;

    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0)
            return null;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder,0,preorder.length-1);

    }
    private TreeNode helper(int[] preorder,int start,int end){
        if(start>end)
            return null;
        int rootVal=preorder[idx];
        idx++;
        int rootIdx=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.left=helper(preorder,start,rootIdx-1);
        root.right=helper(preorder,rootIdx+1,end);
        return root;
    }
}
