import java.util.Arrays;
import java.util.HashMap;

//Construct Binary Tree from Preorder and Inorder Traversal
//TC: O(nh)
//SC: O(h^2)
//Not optimal Sol
class constructBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        //find root node
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootInd = -1;
        //finding the root from inorder array so we know whats in left and right subtrees
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootInd = i;
            }
        }

        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, rootInd);
        int[] inOrderRight = Arrays.copyOfRange(inorder, rootInd + 1, inorder.length);
        int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, rootInd + 1);
        int[] preOrderRight = Arrays.copyOfRange(preorder, rootInd + 1, preorder.length);
//building tree using recursion
        root.left = buildTree(preOrderLeft, inOrderLeft);
        root.right = buildTree(preOrderRight, inOrderRight);

        return root;

    }
}


// Construct Binary Tree from Preorder and Inorder Traversal
// TC: O(n)
// SC: O(n)
// optimal Sol
class constructBTOptimal {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        idx = 0;
        //By creating a hashmap we don't need to iterate over again and again
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode createTree(int[] preorder,int start,int end){
        //base
        if(start>end){
            return null;
        }
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = createTree(preorder,start,rootIdx-1);
        root.right = createTree(preorder,rootIdx+1,end);
        return root;
    }

}