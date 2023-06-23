import java.util.Arrays;


public class BinaryTree_InOrderPre_Recursion {

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            int il = inorder.length;
            int pl = preorder.length;

            //null case
            if(pl == 0) return null;

            // first element in preorder = root
            int rootVal = preorder[0];

            // create a treenode = preorder[0] as root
            TreeNode root = new TreeNode(rootVal);

            // find root index = rI in inorder[] using for loop

            int rI = -1;

            for(int i = 0; i < il; i ++){ // O(n)
                if(inorder[i] == rootVal){
                    rI = i;
                    break;
                }
            }

            // building inLeft, inRight, preLeft, preight arrays
            int[] inLeft = Arrays.copyOfRange(inorder, 0, rI);
            int[] inRight = Arrays.copyOfRange(inorder, rI + 1, il);
            int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
            int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, pl);

            //
            root.left = buildTree(preLeft, inLeft);
            root.right = buildTree(preRight, inRight);

            //
            return root;
        }

}
