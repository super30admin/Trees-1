import java.util.HashMap;
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class ConstructTreeFromPreAndIn {
    private HashMap<Integer, Integer> inorderMap;
    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorderMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end){
            return null;
        }

        //logic
        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);

        //search in the inorder array
        int rootIndex = inorderMap.get(rootValue);
        preIndex++;

        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}