/*

Problem 2 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

TC : O(n)
SC : O(h + n)
Leet Code : Yes

*/

class Solution {

    int indx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return new TreeNode();
        }

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int start, int end){

        if(start > end){
            return null;
        }
        int val = preorder[indx];
        indx++;
        TreeNode root = new TreeNode(val);
        int rootIndex = map.get(val);
        root.left = helper(preorder, start, rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);

        return root;
    }
}