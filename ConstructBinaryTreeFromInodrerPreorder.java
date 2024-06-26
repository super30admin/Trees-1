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
//Time Complexity : O(n) - inorder array length - no of nodes in the tree
//Space Complexity : O(n) - inorder array length
//Did this code run successfully on leetcode : yes
class ConstructBinaryTreeFromInorderPreorder {
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if(inorder.length == 0) return null;
        
    //     int rootVal = preorder[0];
    //     int rootIdx = -1;
    //     for(int i = 0; i < inorder.length; i++) {
    //         if(inorder[i] == rootVal) {
    //             rootIdx = i;
    //         }
    //     }
    //     TreeNode root = new TreeNode(rootVal);
    //     int[] inLeft = Arrays.copyOfRange(inorder,0,rootIdx);
    //     int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
    //     int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
    //     int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

    //     root.left = buildTree(preLeft, inLeft);
    //     root.right = buildTree(preRight, inRight);

    //     return root;
    // }
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
            //base case 
            if(start > end) return null;

            //logic
            int rootVal = preorder[idx];
            idx++;
            TreeNode root = new TreeNode(rootVal);
            int rootIdx = map.get(rootVal);

            root.left = helper(preorder, start, rootIdx-1);
            root.right = helper(preorder, rootIdx+1, end);

            return root;


    }
}