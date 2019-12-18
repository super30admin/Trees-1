// Time Complexity - O(n^2)  where n is the number of nodes in the tree
// Space Complexity - O(n^2)  where n is the number of nodes in the tree
// This solution worked on LeetCode

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder);    
    }
    
    private TreeNode helper(int[] preorder,int[] inorder){
        if(preorder == null || preorder.length==0)  return null;  //Continue the recursive until one of preorder or inorder becomes empty
        TreeNode root = new TreeNode(preorder[0]);  //Root will be the first element of preorder array
        int index =-1;      
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){ 
                index = i;            //find the index of the root in inorder traversal array
                break;
            }
        }
        int[] inleft =  Arrays.copyOfRange(inorder,0,index);          // Use the index to contruct the left subarray 
        int[] inright = Arrays.copyOfRange(inorder,index+1,inorder.length);   // Use the index to contruct the right subarray 
        int[] preleft = Arrays.copyOfRange(preorder,1,index+1);               // split the preorder array for the left subtree
        int[] preright = Arrays.copyOfRange(preorder,index+1,preorder.length);  // split the preorder array for the right subtree
        root.left = buildTree(preleft,inleft);                      //Recursive call to contruct the left subtree
        root.right = buildTree(preright,inright);                      //Recursive call to contruct the right subtree
        return root;
    }
}
