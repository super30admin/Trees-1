/*
Time Complexity- O(n) where n is the number of nodes

Space Complexity- O(n) stack space
 */
import java.util.*;
public class BuildTreeFromPreorderAndInorder {
    class TreeNode1 {
        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1(int val) {
            this.val = val;
            left = right = null;
        }
    }
    HashMap<Integer, Integer> map = new HashMap<>();
     TreeNode1 buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, preorder.length-1);
    }
    int index = 0;
     TreeNode1 constructTree(int[] preorder, int[] inorder, int start, int end) {

        if(start > end) return null;

        int rootVal = preorder[index++];
        TreeNode1 root = new TreeNode1(rootVal);

        root.left = constructTree(preorder, inorder, start, map.get(rootVal) - 1);
        root.right = constructTree(preorder, inorder, map.get(rootVal) + 1, end);

        return root;
    }
    void postorder(TreeNode1 node) {
         if(node != null) {
             postorder(node.left);
             postorder(node.right);
             System.out.print(node.val + "  ");
         }
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BuildTreeFromPreorderAndInorder tree = new BuildTreeFromPreorderAndInorder();
        TreeNode1 root = tree.buildTree(preorder, inorder);
        System.out.println("Root of tree :" + root.val);
        System.out.println("Post Order Traversal");
        tree.postorder(root);

    }
}
