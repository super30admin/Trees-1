//TC: O(n*n)
//SC: O(h) height of tree
// use the definition of binary search tree -- sorted order property
//predecessor value is less than next value in ascending order

//works in leetcode
public class BinaryTreeFromInOrderAndOrderTraversal {
    private static int preorderIndex;
    private static int[] preorder,  inorder;


    public static  TreeNode buildTree(int[] preorder1, int[] inorder1) {
        preorderIndex=0;
        preorder= preorder1;
        inorder=inorder1;
        return buildTree(0, inorder.length-1);
    }

    private static TreeNode buildTree(int inOrderStart, int inOrderEnd){

        //base
        if(inOrderStart > inOrderEnd)
            return null;

        //recursion
        //first element in the preorder is the root
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;


        int inorderIndex = getIndex(inorder, inOrderStart,inOrderEnd, node.val);
        node.left = buildTree(inOrderStart, inorderIndex-1);
        node.right = buildTree(inorderIndex+1, inOrderEnd);
        return node;

    }

    private static int getIndex(int[] arr, int start, int end, int element){
        for(int i=start; i<= end; i++){
            if(arr[i]==element)
                return i;
        }

        return -1;
    }



    public static void main(String [] args){
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode tree =  buildTree(preorder, inorder);
        System.out.println(tree.val);
    }
}
