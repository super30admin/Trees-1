// 105. Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/


/**
 * Time Complexity: O(n) since we traverse all nodes
 * Space Complexity: O(n) + o(h) = o(n)  where n is no. of elements stored in map and h is height of the tree 
 */

class Solution {

    int preIdx = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0 ; i < inorder.length ; i++){ // store inorder elements in map to get index of root
            this.map.put(inorder[i], i);
        } 

        return helper(preorder, inorder, 0, preorder.length - 1);     
    }

    private TreeNode helper(int pre[], int in[], int start, int end) {
        // base condition
        if(start > end){
            return null;
        }

        int rootIdx = map.get(pre[preIdx]);
        TreeNode root = new TreeNode(pre[preIdx]);

        preIdx += 1; // move to next root from preorder

        TreeNode leftNode = helper(pre, in, start, rootIdx - 1);  // reduce the left range

        TreeNode rightNode = helper(pre, in, rootIdx + 1, end);   // reduce the right range

        root.left = leftNode;
        root.right = rightNode;

        return root;  
    }
}