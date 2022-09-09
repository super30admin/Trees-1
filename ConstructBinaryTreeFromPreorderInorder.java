// Time complexity: O(N)
// Space complexity: O(N)

// Approach: We first add all elements of inorder array to hashmap so that we can get fast access. We keep an index for preorder array to keep track of the root that needs to be built.
// Implement recursive method which takes a range of inorder (start and end) and returns the constructed binary tree:
// if the range is empty, return null;
// initialize the root with preorder[preorderIndex] and then increment preorderIndex;
// recursively use the left and right portions of inorder to construct the left and right subtrees.

class Solution {
    HashMap<Integer,Integer> map;
    int preorderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx = 0;
        // build a hashmap to store value -> its index relations
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        // base
        // if there are no elements to construct the tree. If start has exceeded end
        if (start > end) return null;
        
        // logic
        // select the preorder_index element as the root and increment the preorder index
        TreeNode root = new TreeNode(preorder[preorderIdx]);
        preorderIdx++;
        int rootIdx = map.get(root.val); // get roots index in inorder map
        root.left = helper(preorder, start, rootIdx-1); // build left subtree
        root.right = helper(preorder, rootIdx+1, end); // build right subtree
        return root;
    }
}