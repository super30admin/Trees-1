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
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder.length == 0) return null;

//         int rootVal = preorder[0];
//         int rootIdx = -1;

//         for(int i = 0; i < inorder.length; i++){//O(n)
//             if(inorder[i] == rootVal){
//                 rootIdx = i;
//                 break;
//             }
//         }

//         TreeNode root = new TreeNode(rootVal);

//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);//collectivelty O(2n) by n/2 4 times
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
//         int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
//         int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

//         root.left = buildTree(preLeft, inLeft);// happening for each node above 3n so total tc- O(n^2)
//         root.right = buildTree(preRight, inRight);

//         return root;
//     }
// }


//optimized tc- O(n){hashmap} + O(n)- traversal
//sc- O(n) hasgmap O(h) stack


class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.idx = 0;
        this.map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0 , inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int start, int end){
        //base

        if(start > end) return null;

        //logic

        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }
}