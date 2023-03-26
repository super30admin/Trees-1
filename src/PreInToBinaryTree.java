// Time Complexity:           O(n)
// Space Complexity:          O(n+h)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.HashMap;
import java.util.Map;

public class PreInToBinaryTree {
    int preIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i],i);                                                     // storing all inorder elements' order
        return build(preorder, 0, inorder.length-1);
        
// // ******************** Another method ********************
        
//         // Base case
//         if(preorder.length == 0) return null;

//         // getting indexes of root node in preorder and inorder
//         int rootVal = preorder[0];
//         int rootIndIn = -1;
//         for(int i=0; i<inorder.length; i++) {
//             if(inorder[i] == rootVal) {
//                 rootIndIn = i;
//                 break;
//             }
//         }

//         // left and right subarrays for recursion
//         int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndIn+1);
//         int[] preRight = Arrays.copyOfRange(preorder, rootIndIn+1, preorder.length);
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndIn);
//         int[] inRight = Arrays.copyOfRange(inorder, rootIndIn+1, inorder.length);

//         // Recursion
//         TreeNode root = new TreeNode(rootVal);
//         root.left = buildTree(preLeft, inLeft);
//         root.right = buildTree(preRight, inRight);

//         return root;
        
    }
    private TreeNode build(int[] preorder, int start, int end) {
        if(start > end)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);                            // creating new node to be added in a tree(new temp root)

// ******************** Not need to handle these cases ********************
//         if(root == null)                                                            
//             return null;
//         if(start == end)                                                               // leaf node
//             return root;

        int index = map.get(root.val);

        root.left = build(preorder, start, index-1);                                   // creating left child subtree
        root.right = build(preorder, index+1, end);                                    // creating right child subtree

        return root;
    }
}
