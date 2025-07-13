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
        /*if (preorder.length == 0 || inorder.length == 0) {
        return null;
    }
        TreeNode root=new TreeNode(preorder[0]);
        int rindex=-1;
        for(int i=0;i<inorder.length;i++){
if(root.val==inorder[i]){rindex=i;
break;}
        }
        int[] pleft=Arrays.copyOfRange(preorder,1,rindex+1);
        int[] pright=Arrays.copyOfRange(preorder,rindex+1,preorder.length);
        int[] ileft=Arrays.copyOfRange(inorder,0,rindex);
        int[] iright=Arrays.copyOfRange(inorder,rindex+1,inorder.length);
        root.left=buildTree(pleft,ileft);
        root.right=buildTree(pright,iright);
        return root;*/


        //Using hashmap and pointers to avoid the copying of array

    HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        this.idx = 0;
        return helper(preorder, 0, preorder.length - 1, map);
    }
     private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map){
        // base case
        if(start > end) return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1, map);
        root.right = helper(preorder, rootIdx + 1, end, map);
        
        return root;
    }

}