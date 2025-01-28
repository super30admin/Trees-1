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
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        idx=0;
        map =new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return createTree(preorder, 0, inorder.length-1);
    }

    private TreeNode createTree(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }

        int rootval = preorder[idx];
        idx++;

        TreeNode root = new TreeNode(rootval);
        int rootidx = map.get(rootval);
        root.left = createTree(preorder,start,rootidx-1);
        root.right = createTree(preorder,rootidx+1,end);

        return root;
    }
}