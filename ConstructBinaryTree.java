//TC, SC =  O(n*n)
// Here we are fiding first root from preorder then looking that root in inorder and 
//then making four two array for each for left and right tree

class ContructBinaryTree{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
                if(preorder.length == 0) return null;
                int rootVal = preorder[0];
                TreeNode root = new TreeNode(rootVal);
                int index = -1;
                for(int i=0; i<inorder.length; i++){
                    if(inorder[i] == rootVal){
                        index = i;
                        break;
                    }
                }

                int[] intLeft = Arrays.copyOfRange(inorder, 0 , index);
                int[] intRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
                int[] preLeft = Arrays.copyOfRange(preorder, 1, intLeft.length+1);
                int[] preRight = Arrays.copyOfRange(preorder, intLeft.length+1, preorder.length);

                root.left = buildTree(preLeft,intLeft);
                root.right = buildTree(preRight,intRight);
                return root;   
    }
}