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
// o(n) time and o(h) space for recurrsion
class Solution {
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        result = true;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);
        //st.pop()
        if(prev!= null && prev.val >= root.val){
            result = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}

//o(n) space and time

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx; //index on preorder arr;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0) return null;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);


    }
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end) return null;
        //logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal); //idx of root in my inorder array
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;

    }
}
    