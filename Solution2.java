// Time complexity: O(N), where N is the number of nodes in the tree.
// Space complexity: O(N)

import java.util.*;

class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // preorder - root, left, right
    // inorder - left, root, right
    
    // maintaing an index for the preorder array.
    int index = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>(); 
    public TreeNode helper(int[] preorder, int low, int high) {
        if(low <= high) {
            int val = preorder[index++];
            int valIndex = inorderMap.get(val);
            // root
            TreeNode root = new TreeNode(val);
            // left tree
            root.left = helper(preorder, low, valIndex - 1);
            // right tree
            root.right = helper(preorder, valIndex+1, high);
            return root; 
        }
        return null; 
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // putting elements in a map since there are no duplicates and it takes O(1) lookup time.  
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i); 
        }
        return helper(preorder, 0, inorder.length-1); 
    }
}
