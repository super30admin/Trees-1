/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * // Tc: O(N) Sc: O(N)
 * class Solution {
 * TreeNode prev;
 * boolean flag = true;
 * 
 * public boolean isValidBST(TreeNode root) {
 * inorder(root);
 * return flag;
 * 
 * }
 * 
 * private void inorder(TreeNode root) {
 * if (root == null)
 * return;
 * inorder(root.left);
 * if (prev != null && prev.val >= root.val)
 * flag = false;
 * prev = root;
 * if (flag)
 * inorder(root.right);
 * }
 * }
 * 
 * class Solution {
 * List<Integer> arr = new ArrayList<>();
 * 
 * public boolean isValidBST(TreeNode root) {
 * inorder(root);
 * for (int i = 0; i < arr.size() - 1; i++) {
 * if (arr.get(i) >= arr.get(i + 1))
 * return false;
 * }
 * return true;
 * }
 * 
 * private void inorder(TreeNode root) {
 * if (root == null)
 * return;
 * inorder(root.left);
 * arr.add(root.val);
 * inorder(root.right);
 * }
 * }
 * 
 */