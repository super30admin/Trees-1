// Time Complexity : O(n)  - size of preorder 
// Space Complexity : O(m) - size of inorder (hashmap)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    HashMap<Integer,Integer> map;
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length-1);
        }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base case
        if(start > end) return null;
        
        //logic
        
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = helper(preorder,inorder, start, rootIndex - 1);
        root.right = helper(preorder,inorder, rootIndex + 1, end);
        return root;
    }
}