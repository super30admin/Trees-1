package Trees1;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import java.util.HashMap;

// Your code here along with comments explaining your approach
public class BuildTreeFromPreAndInorder {
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int low, int high){
        if(low > high || idx >= preorder.length)
            return null;
        int rootIdx = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = helper(preorder, low, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, high);
        return root;
    }
}
