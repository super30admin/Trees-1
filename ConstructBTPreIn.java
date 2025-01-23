// We know that first element of preorder will be our root and then locating the position of root in inorder, then dividing recursively
// the inorder array and preorder array to construct the left and right subtrees. Elements to the left of root will be in left subtree
// and vice versa. So, then again the root of left subtree will be the next element in preorder array, so repeat same steps.

// Time Complexity : O(H^2)
// Space Complexity : O(H^2) - Recursive stack space and creating 4 arrays for each node
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case
        if (preorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // First value in preorder is the root of the tree
        int rootVal = preorder[0];
        // Create a root node
        TreeNode root = new TreeNode(rootVal);
        // Initialize the index of rootnode in inorder to be -1
        int rootIdx = -1;
        // Iterate through inorder array and find out the position of root node
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        // Create the left and right subtree preorder and inorder arrays with the help
        // of position of root
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        int[] inrderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inrderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        // Recursively call the function for creating the left and right subtrees
        root.left = buildTree(preorderLeft, inrderLeft);
        root.right = buildTree(preorderRight, inrderRight);
        // Return root
        return root;

    }
}

// Optimized approach:
// In this approach, using hashmap for O(1) lookup for the index of the root in
// each call. And also instead of creating new arrays everytime, just keeping
// the indices start and end for the inorder array, so it will be space
// optimized as well.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    // This is the idx of root, which will be given by incrementing everytime from
    // preorder array
    int idx;
    // Hashmap for storing the all the nodes of inorder array and it's index
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case
        if (preorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // Initialize map and idx
        map = new HashMap<>();
        idx = 0;
        // Put all the nodes of inorder array and it's index in hashmap
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // Call the recursive createtree function with start as 0 and end as
        // inorder.length-1
        return createTree(preorder, 0, inorder.length - 1);

    }

    private TreeNode createTree(int[] preorder, int start, int end) {
        // Base case, any point if start is > end, that we means we have reached to the
        // leaf node and there are no more left and right subtrees to that node, so
        // return null
        if (start > end) {
            return null;
        }
        // Root will be given from preorder array
        int rootVal = preorder[idx];
        // Increment the index to get the correct root in the next recursive call
        idx++;
        // Then create that root node
        TreeNode root = new TreeNode(rootVal);
        // Get the position of root node in inorder array
        int rootIdx = map.get(rootVal);
        // Make the left recursive call, so the start will be same and end will be root
        // idx - 1
        root.left = createTree(preorder, start, rootIdx - 1);
        // Make the right recursive call, start rootidx+1 and end as same
        root.right = createTree(preorder, rootIdx + 1, end);
        // return root
        return root;
    }
}