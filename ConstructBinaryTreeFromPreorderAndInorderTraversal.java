// Time Complexity : O(n) where n=no. of nodes in the tree
// Space Complexity : O(n+h) and n is no of nodes in the tree for hash map , h is height of the tree for recursive stack,
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We are using the recursive approach. We use the Hash map to optimize the iteration of inorder traversal, which stores
 * the root val and index in the map. We use the idx pointer to iterate over the preorder array.
 * */



import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    Map<Integer, Integer> map;
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null) return null;

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(preorder, inorder, 0, inorder.length-1);

    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        //base
        if(start>end) return null;

        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        idx++;
        root.left = helper(preorder, inorder, start, rootIdx-1 );
        root.right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }
}
