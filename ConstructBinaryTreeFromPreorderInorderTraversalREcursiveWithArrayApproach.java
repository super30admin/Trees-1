// Time Complexity :O{n2} Traversal + recursion at each node
// Space Complexity :O(n2) -> Recursive and stack
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //Serialization, Deserialization
        //Its not possible to build BST, without inorder
        
        //Identify the root from Preorder .Once that is identified from the Preorder ,find that in the Inorder, the left of root found in the inorder is the left subtree and right is the right subtree
        //In preorder ,the tranverse sequence is  root, left and then right. 
        //In Inorder,the traverse sequence is left, root and right
        //In preorder, the first index is the root.So search that root in the inorder .Once we find it in inorder ,left of root is the left subtree and right of the root is the right subtree 
        //With that info find the left and right subtree in preorder.
        //In preorder, from the left subtree we can again find the root which will be the first one in the left preorder subtree. Use that root identified in preorder to find the left and right of left and right subtree
        
        
        if(preorder == null || preorder.length ==0)
            return null;
        
        //find root in preorder
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        
        //search root in preorder
        int rootIdx = 0;
        for(int i = 0; i < inorder.length ; i++){
            if(inorder[i] == rootVal)
                rootIdx = i;
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);//unlike substring, copyOfRange will exclude the end index
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
        
    }
}