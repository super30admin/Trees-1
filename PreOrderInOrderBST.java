
// Time Complexity : O(N) - N are the number of nodes in the tree
// Space Complexity : O(N) - As we used HashMap as a additional data structure
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english 
/* Used a HashMap to store inorder values and corresponding Indexes.We will traverse through the preorder array and check for each element in map.
Retrieve the index from the HashMap and we call the helper function again for corresponding left and right nodes */
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
    int preindex = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> map1 = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0;i < inorder.length;i++){
            map1.put(inorder[i],i);
        }
        return helper(0,inorder.length - 1);
    }
    public TreeNode helper(int left,int right){
        if(left > right) return null;
        int root_val = preorder[preindex++];
        int index = map1.get(root_val);
        TreeNode root = new TreeNode(root_val);
        root.left = helper(left,index - 1);
        root.right = helper(index + 1,right);
        return root;
    }
}
// Your code here along with comments explaining your approach
