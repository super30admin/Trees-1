// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) recursive stack of n calls in a skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: We are given inorder and preorder array => the very first value of preorder array is root value.
Store the inorder array into a hashmap to maintain a relationship of element and index to have O(1) fetch in future. Create the tree node with
root value initially, fetch the root value index from the inorder hashmap store. Inorder array always tells us that the elements before root are left subtree
and the elements after root are right subtree, and we know the root index. So we know that from 0 to index-1 is the left subtree, and from index+1
till the end is the right subtree. Recursively, fetch the nodes from the left subtree and futher divide them into left and right subtrees. Similarly,
fetch the nodes from right subtree and repeat the steps mentioned above to form the tree.
*/

class Solution {
    int inPre =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0,   inEnd = preorder.length-1;
        HashMap<Integer, Integer> store = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            store.put(inorder[i],i);                            // store the inorder array for O(1) fetch
        }
        return constructTree(preorder, inorder, inStart, inEnd,  store);
    }
    private TreeNode constructTree(int[] preorder, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> store){
        if(inPre > preorder.length-1 || inStart > inEnd) {return null;}                 // Base Condition
        TreeNode node = new TreeNode(preorder[inPre++]);                                // Make the tree node using preorder indices
        int index = store.get(node.val);                                                // Fetch the node value inorder index
        node.left = constructTree(preorder, inorder, inStart, index-1, store);          // Traverse to left subtree 0 to index-1
        node.right = constructTree(preorder, inorder, index+1, inEnd,  store);          // Traverse to right subtree index+1 to end
        return node;
    }
}