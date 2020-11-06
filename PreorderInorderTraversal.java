//Time complexity: O(N)
//Space Complexity: O(N)
//Ran on leetcode and accepted
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //If the arrays are empty return null
        if(preorder == null || inorder == null || inorder.length ==0|| preorder.length==0) return null;
        //Find the root element from preorder (1st element of preorder is the root)
        TreeNode root = new TreeNode(preorder[0]);
        //If there is only 1 element in the preorder then return the root
        if(preorder.length==1)return root;
        //set index to -1
        int index=-1;
        //Iterate over inorder 
        for (int i = 0; i< inorder.length; i++)
        {
            //if the value in inorder is the root value 
            if(inorder[i]==root.val)
            {
                //store the i of root in index
                index = i;
            }
        }
        //get the left part of the tree from preorder
        int[] preleft = Arrays.copyOfRange(preorder,1,index+1);
        //get the left part of the tree from inorder
        int[] inleft = Arrays.copyOfRange(inorder,0,index);
        //get the right part of the tree from preorder
        int[] preright = Arrays.copyOfRange(preorder, index+1,preorder.length);
        //get the right part of the tree from inorder
        int[] inright = Arrays.copyOfRange(inorder,index+1,inorder.length);
        //find the root for left part and root for right part iteratively
        root.left= buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        
        //return root
        return root;
    }
}