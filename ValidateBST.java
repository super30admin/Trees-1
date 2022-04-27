// Time Complexity : O(n) n is num of elements in tree
// Space Complexity : O(h) contains n elements in stack at worst
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import javax.swing.tree.TreeNode;
import java.util.Stack;


//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
//}
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Integer prev = null;
        while(root!= null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && root.val <= prev) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}