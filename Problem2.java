import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

/**
 * Approach 1: We get the root from preorder array, then we find the index of root in the inorder
 * array. Now the 0-(rootIdx-1) is the inLeft array and (rootIdx+1)-inorder.length is the inRight
 * array. Similarly, 1-(inLeft.length + 1) is the preLeft and (1+inLeft.length)-preorder.length
 * is the preRight array. We create new arrays and perform recursion on them. TC => O(n^2). SC => O(n^2)
 *
 * Approach 2: To save from iterating over the inorder array everytime to find the rootIdx,
 * we store the indices of the inorder array's element in a map. And instead of creating new arrays
 * everytime, we use pointers start and end.
 * When going left - start remains same and end changes to rootIdx-1
 * When going right - start changes to rootIdx+1 and end remains same
 */

public class Problem2 {


    private Map<Integer, Integer> map;
    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1, preorder);

    }

    private TreeNode helper(int start, int end, int[] preorder) {
        //base
        if (start > end) return null;

        //logic
        int rootVal = preorder[idx];
        idx++;

        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        root.left = helper(start, rootIdx - 1, preorder);
        root.right = helper(rootIdx + 1, end, preorder);

        return root;
    }
}
