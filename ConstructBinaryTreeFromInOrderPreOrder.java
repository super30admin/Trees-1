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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1, map);
    }
    public TreeNode helper(int preorder[], int start, int end, HashMap<Integer, Integer> map){
        if(idx>=preorder.length || start>end){
            return null;
        }
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        System.out.println(rootVal+" "+start+" "+(rootIdx-1)+" "+(1+rootIdx)+" "+end+" "+(idx-1));
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx-1, map);
        root.right = helper(preorder, 1+rootIdx, end, map);
        return root;
    }
}