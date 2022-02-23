// Time Complexity : O(n) where n = number of nodes in the tree
// Space Complexity : O(n) where n = number of nodes in the tree [due to recursion stack]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
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
 
public class Problem1 {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private static boolean isValidBST(TreeNode root, Integer lower_limit, Integer upper_limit) {
        // If root is null, it is a valid BST
        if (root == null) {
            return true;
        }
        // If the present node's value is not between lower limit and upper limit, return false
        if ((lower_limit != null && root.val <= lower_limit) || (upper_limit != null && root.val >= upper_limit)) {
            return false;
        }
        // Check if left subtree is a valid BST. 
        // Obviously for left subtree, the upper limit is updated to value of the root
        boolean leftans = isValidBST(root.left, lower_limit, root.val);
        // Check if right subtree is a valid BST. 
        // Obviously for right subtree, the lower limit is updated to value of the root
        boolean rightans = isValidBST(root.right, root.val, upper_limit);
        // If either of left subtree or right subtree is not a valid BST, return false, else return true
        return leftans && rightans;
    }

    public static TreeNode makeTree(Integer[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        if (arr[i] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[i]);
        root.left = makeTree(arr, 2 * i + 1);
        root.right = makeTree(arr, 2 * i + 2);
        return root;
    }

    // Function to print the binary tree
    public static void printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
          return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(null);      
            } else {
                q.add(curr.left);
                q.add(curr.right);
                res.add(curr.val);
          }
        }
        int i = res.size()-1;
        while (res.get(i) == null) {
            res.remove(i--);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Integer[] levelarr = {5,1,4,null,null,3,6};
        TreeNode root = makeTree(levelarr, 0);
        // printTree(root);
        boolean ans = isValidBST(root);
        System.out.println("\n" + ans);
    }

}