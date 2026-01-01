// Time Complexity : O(n).
// Space Complexity : O(n) space for hash map.
// Did this code successfully run on Leetcode : Yes
// Approach : The idea is, the first element of pre-order will be the root and it's corresponding position in the inorder array gives the left and right subtrees from it's left and right
// sides of the index position found. We do this process by storing the elements of inorder array in hashmap as search is O(1). We maintain start and end pointers, and find the index
// of preorder array's value in inorder array. The left side of that index gives the left subtree and right gives the right subtree. We recurse until start and end ointer cross each other,
// which means the corresponding children are null.

class Solution {
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.idx = 0;
        this.map = new HashMap<>();
        for(int i = 0; i< inorder.length;i++){ //hashmap to store indices of inorder array so that search is O(1)
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start > end){
            return null;
        }
        //logic
        TreeNode node = new TreeNode(preorder[idx]); //create a node with preorder[idx as root]
        int p = map.get(preorder[idx]); //get the index of corresponding inorder array
        idx++;
        node.left = helper(preorder, start, p-1); //build left part of node
        node.right = helper(preorder, p+1, end); //build right part of node
        return node;
    }
}