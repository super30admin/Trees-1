//TC: O(n) -- for finding the root in inorder traversal
//SC: O(n) -- hashmap
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
    
    HashMap<Integer, Integer> map; //to store inorder elements for search O(1)
    int index; //pointer on preorder array
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //null check
        if(preorder == null || preorder.length == 0) return null;
        
        //putting inorder values in hashmap
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);  
        }
        return helper(preorder, 0,  inorder.length - 1); 
    }
    
    public TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end) return null;

        //logic
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal); //storing root in the tree
        
        //inorder traversaal
        
        int rootIndex = map.get(rootVal); //finding root in inorder's hashmap
        root.left = helper(preorder, start, rootIndex - 1); //calling recursive func to construct left side of tree
        root.right = helper(preorder, rootIndex + 1, end);//calling recursive func to construct right side of tree
        return root;
    }
}