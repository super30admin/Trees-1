// we just follow the preorder and inorder rules. First take the first element in the preorder traversal and find the same element in 
// inorder traversal, so the element towards left in the inorder array will form the left subtree and element towards the right 
// will form the right subtree. We continue this until all the elements are exhausted. 

// Time Complexity : O(N)
// Space Complexity : O(N)

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    int preindex;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preindex = 0;
        map = new HashMap<>();
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }

        return buildTree(0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode buildTree(int l, int r, int[] preorder, int[] inorder) {
        if (l > r)
            return null;

        int rootVal = preorder[preindex];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        preindex++;
        root.left = buildTree(l, rootIndex - 1, preorder, inorder);
        root.right = buildTree(rootIndex + 1, r, preorder, inorder);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        BuildTree tree = new BuildTree();

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = tree.buildTree(preorder, inorder);
        tree.printTree(root);
    }
}
