// Time Complexity : O(N), N is the number of nodes in preorder/inorder array
// Space Complexity : O(h), H is the height of tree, that will be max number of recursion frames
//  + O(N), N number of values in inorder array that will be stored in HashMap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
// From preorder array we can identify the root node index. From the inorder array we can find the start and end index of
// left subtree. Similarly, the start and end index of right subtree. Once a root node is created, we can move to the
// next root by incrementing index.

// To find the start and end indices of the subtrees in constant time, we can store them in a map.
import java.util.HashMap;
import java.util.Map;

public class ConstructTree {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        int start = 0;
        int end = len - 1;
        return getBinaryTree(indexMap, preorder, start, end);
    }

    private TreeNode getBinaryTree(Map<Integer, Integer> indexMap, int[] preorder, int start, int end) {
        // If the preorder array is evaluated, all roots are done, so return null.
        // If the start and end of a subtree has crossed, we are done evaluating it and return null.
        if (index > preorder.length || start > end) {
            return null;
        }

        int currentRoot = preorder[index++];
        int currentRootIndex = indexMap.get(currentRoot);
        // Create left subtree from parent start to parent index -1.
        TreeNode left = getBinaryTree(indexMap, preorder, start, currentRootIndex - 1);

        // Create right subtree from parent index +1 to parent index end.
        TreeNode right = getBinaryTree(indexMap, preorder, currentRootIndex + 1, end);

        // Create current node and pass it to parent.
        return new TreeNode(currentRoot, left, right);
    }
}
