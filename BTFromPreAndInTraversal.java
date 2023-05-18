// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach
/*
 * We use the fact that elements to the left of the root index in the inorder list is left tree and to the right is right tree
#  Recursively call the function creating new Arrays with bound. 
*/

import java.util.Arrays;
import java.util.HashMap;

class BTFromPreAndInTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        int rootVal = preorder[0];
        
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx); // copies 1 less
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length); 
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach
/*
 * To optimize above approach we use hashmap for inorder and start and end pointer for preorder. idx tracks root node
 * of subtree. We then calculate start and end index from map and call recursively on left and right 
 * subtree and return root. 
*/
class BTFromPreAndInOptimize {
    HashMap<Integer, Integer> map; 
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        //Base case
        if(start > end) {
            return null;
        }
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}
