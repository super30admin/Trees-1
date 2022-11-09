

// TC : O(n) // n = preorder.length
// SC : O(n)


package S30_Codes.Trees_1;
import java.util.HashMap;
import java.util.Map;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> map;
    int[] preorder,inorder;
    int preorderIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preorderIdx = 0;

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(0, inorder.length-1);
    }

    private TreeNode buildTree(int inorderStartIdx, int inorderEndIdx){
        if(inorderStartIdx>inorderEndIdx)
            return null;

        TreeNode newNode = new TreeNode(preorder[preorderIdx]);
        preorderIdx++;

        int nodeInInorderIdx = findNodeInInOrder(newNode.val);
        newNode.left =  buildTree(inorderStartIdx, nodeInInorderIdx-1);
        newNode.right = buildTree(nodeInInorderIdx+1, inorderEndIdx);
        return newNode;
    }

    private int findNodeInInOrder(int val){
        return map.get(val);
    }
}