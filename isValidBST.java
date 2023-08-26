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

class Solution {

public boolean isValidBST(TreeNode currentNode) {
    if (currentNode == null) return true;
    Stack<TreeNode> nodeStack = new Stack<>();
    TreeNode lastVisitedNode = null;
    while(currentNode != null || !nodeStack.isEmpty()){
        while(currentNode != null){
            nodeStack.push(currentNode);
            currentNode = currentNode.left;
        }
        currentNode = nodeStack.pop();
        if(lastVisitedNode != null && currentNode.val <= lastVisitedNode.val) return false;
        lastVisitedNode = currentNode;
        currentNode = currentNode.right;
    }
    return true;
}

}