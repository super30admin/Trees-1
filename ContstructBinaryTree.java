//Time : O(n) : n=length of array
//space : O(h) : h = height of tree created
// did it run successfully on leetcode: yes
class ConstructBinaryTree {
    //global index for preorder array
    int preInd=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode  root;
        //helper method to create the BT
        root = helper(preorder,inorder, 0, inorder.length-1);
        //returning the root of tree
        return root;
    }

    public TreeNode helper(int[] pre, int[] in, int l, int r){
        //left and right boundary crosses
        if(l>r){
            //decreement preIndex since it is not a valid node in preorder array
            preInd--;

            return null;
        }
        //create a node with value at preIndex as root
        TreeNode root = new TreeNode(pre[preInd]);

        //one element in sub-array
        if(l==r) return root;
        //get index of root in inorder array
        int inInd = getIndex(in, pre[preInd]);
        //set value at next preorder array as next root
        preInd++;
        //left child of root
        root.left =  helper(pre, in, l, inInd-1);
        //set value at next preorder array as next root
        preInd++;
        //right child of root
        root.right =  helper( pre,  in, inInd+1, r);

        return root;
    }

//return index of a value in array
    public int getIndex(int[] in, int val){
        for(int i=0; i<in.length; i++){
            if(in[i] ==val) return i;
        }
        return -1;
    }
}