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
   int preorderIndex;//A variable to keep track of current index in preorder traversal array

   Map<Integer, Integer> inorderIndexMap;//A hashmap to store the index of each value in the inorder traversal array


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //initialize the preorder traversal to 0
        preorderIndex=0;
        //Build a ahashmap to store the value-to-index mapping for inorder array
        inorderIndexMap =new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
            //store each values index from inorder array
        }

        //Call the recursive helper function to construct the tree
        return arrayToTree(preorder,0,preorder.length-1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right){
        //if there are no elements to construct the tree (basecase)
        if(left>right) return null;

        //Select the current preorder Index element as the root & increment preorder Index
        int rootValue= preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        //Create the root node with the selected value

        //Recursively build the left subtree
        //The left subtree will consist the elements before the root element in the inorder array

        root.left=arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);

        //Recursively build the right subtree
        //The right subtree will consist of elements before the root element in the in the inorder array

        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);

        //Return the root node of the subtree
        return root;
    }


        
    
}