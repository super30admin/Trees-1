/**
Time Complexity : O(N)
Space Complexity : O(D) depth of the binary tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    int preStart = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return buildTreeHelper( 0, preorder.length-1, preorder,inorder);
    }
    
    private TreeNode buildTreeHelper(int inStart, int inEnd,int preorder[], int inorder[])
    {
        if(preStart <0 || preStart == preorder.length || inStart>inEnd)
            return null;
        
        int currentVal = preorder[preStart++];
        TreeNode rootNode = new TreeNode(currentVal);
        int inIndex = getIndexInInorder(currentVal, inorder);
        
        int elementsInLeft = inIndex - inStart;
        int elementsInRight = inEnd - inIndex;
        
        int leftInStart = inStart;
        int leftInend = inIndex -1;
        int rightInStart = inIndex + 1;
        int rightInEnd = inEnd;
            
        rootNode.left = buildTreeHelper(leftInStart, leftInend, preorder, inorder);
        rootNode.right = buildTreeHelper(rightInStart, rightInEnd, preorder, inorder);
        return rootNode;
    }
    
    private int getIndexInInorder(int value, int inorder[])
    {
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==value)
                return i;
        }
        
        return -1;
    }
}