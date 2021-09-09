time complexity: O(n)
space complexity: O(h)

//From the pre-order array, we know that first element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
//Using the length of left sub-tree, we can identify left and right sub-trees in pre-order array. Recursively, we can build up the tree.
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    int preStart = 0; //initiating the start and end indexes of both preorder and inorder arrays
    int preEnd = preorder.length-1;
    int inStart = 0;
    int inEnd = inorder.length-1;
 
    return construct(preorder, preStart, preEnd, inorder, inStart, inEnd); //making a recursive call
}
 
public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){ //initial check
        return null;
    }
 
    int val = preorder[preStart]; //taking the first value from preorder array, since the first value is the root.
    TreeNode p = new TreeNode(val); //creating a root node 
 
    //finding parent element index from inorder
    int k=0;
    for(int i=0; i<inorder.length; i++){
        if(val == inorder[i]){
            k=i;
            break;
        }
    }
 
    p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1); //performing recursive calls for left and right
    p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
 
    return p;
}  
    }