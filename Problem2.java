import java.util.Arrays;

public class Problem2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int index = -1;
        for (int i = 0; i < inorder.length; i++) // find root in inorder
            if(inorder[i] == root.val)
                index = i;

        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        System.out.println(Arrays.toString(preLeft));

        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }

    public static void main(String[] args) {

    }

}
