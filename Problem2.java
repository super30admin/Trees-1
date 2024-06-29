// Time complexity : O(n)
// Space complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic:Use a HashMap to store the indices of the inorder traversal for quick access.
//Recursively build the tree by picking elements from the preorder array (which gives root nodes) and using the HashMap to divide the inorder array into left and right subtrees.
//Continue the process until all elements are processed, thereby constructing the entire tree.

class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0|| inorder == null || inorder.length == 0){
            return null;
        }

        map = new HashMap<>();
        index = 0;
        for(int i =0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        return recurse(preorder, 0, inorder.length - 1);
    }

    private TreeNode recurse(int[] preorder, int start, int end){
        // base
        if(start > end){
            return null;
        }

        int rootval = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootval);
        int rootIndex = map.get(rootval);
        root.left = recurse(preorder, start, rootIndex-1);
        root.right = recurse(preorder, rootIndex+1, end);

        return root;
    }
}