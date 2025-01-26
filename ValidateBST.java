import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
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

public class ValidateBST {

    // for isValidBSTWithExtraSpace approach: This uses ArrayList
    // TC: O(n) as all the nodes are traversed for adding in the list
    // SC: O(n) as the arrayList stores all the elements for comparing

    // for isValidBSTIterative approach: This uses stack.
    // TC: O(n) as all the nodes are traversed
    // SC: O(h) where h is the height of the stack which is equal to the total level
    // of the treeNode.
    // Stack height will never be equal to the total numbers of the elements.
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBSTWithExtraSpace(node));
        System.out.println(isValidBSTIterative(node));

        TreeNode node1 = new TreeNode(5, new TreeNode(1), new TreeNode(4));
        node1.right.left = new TreeNode(3);
        node1.right.right = new TreeNode(6);
        System.out.println(isValidBSTWithExtraSpace(node1));
        System.out.println(isValidBSTIterative(node1));
    }

    static boolean isValid;
    static Stack<TreeNode> stack;
    static TreeNode prev;
    static List<Integer> ascendingElements;

    private static boolean isValidBSTWithExtraSpace(TreeNode root) {
        isValid = true;
        ascendingElements = new ArrayList<>();
        dfs(root);
        for (int i = 1; i < ascendingElements.size(); i++) {
            if (ascendingElements.get(i) <= ascendingElements.get(i - 1)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    // Helper method: Inorder traversal is carried out
    private static void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        ascendingElements.add(root.val);
        dfs(root.right);
    }

    // Iterative method where stack is used to push the left most.
    // Prev is set to the current root. parallely comparing it and returns false if
    // root.val <= prev.val
    private static boolean isValidBSTIterative(TreeNode root) {
        isValid = true;
        prev = null;
        stack = new Stack<>();
        if (root == null)
            return true;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) {
                isValid = false;
                break;
            }
            prev = root;
            root = root.right;
        }

        return isValid;
    }

}