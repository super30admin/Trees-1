import java.util.*;

class Solution {
    // Iterative solution
    // Time complexity is O(n)
    // Space complexity is O(h) i.e height of the tree
    public class TreeNode {
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
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> St = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int currSum = 0;
        int sum = 0;
        while(root!= null || !St.isEmpty()){
            while(root!= null) {
                currSum = currSum*10 + root.val;
                St.push(root);
                numSt.push(currSum);
                root = root.left;
            }
            // Stack pop operation
            root = St.pop();
            currSum = numSt.pop();
            // check for leaf node
            if(root.left == null && root.right == null){
                sum = sum + currSum;
            }
            root = root.right;
        }
        return sum;
    }
}