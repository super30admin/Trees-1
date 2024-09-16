// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree. it can be O(n) in case of skewed tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||inorder.length==0)
            return null;
        map = new HashMap<>();
        idx = 0;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    private TreeNode helper(int[]preorder, int start, int end){
        if(start>end)
            return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1,end);
        return root;
    }
}