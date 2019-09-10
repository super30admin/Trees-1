//Time Complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll be creating a list node that will contain my BST. SInce the first element in preorder traversal will always be root, I'll assign that as my root in my BST. I'll then traverse through the inorder traversal array to find the position of the root element and mark its index. This index will tell me that those to its left form the left portion and those to its right form the right portion of the tree. I'll recursively calculate the left and the right part in the preorder and the inorder array and will construct the tree. 
//This code was executed successfully and got accepted in leetcode.


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || inorder.length==0 || preorder.length==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        if(preorder.length==1) return root;
        int index=-1;
        for(int i=0;i<preorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        int[] preleft=Arrays.copyOfRange(preorder,1,index+1);
        int[] inleft=Arrays.copyOfRange(inorder,0,index);
        int[] preright=Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left=buildTree(preleft,inleft);
        root.right=buildTree(preright,inright);
        
        return root;
    }
}