import java.util.HashMap;

class ConstructBinaryTreeFromPreAndIn {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    HashMap<Integer, Integer> map;
    int index; // pointer on the inorder array which will give me next root
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null
        if(preorder == null || preorder.length == 0) return null;

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i); //storing the positions of inorder elements
        }
        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end) return null;

        //logic
        int rootVal = preorder[index];
        int rootIdx = map.get(rootVal); //index of root in inorder array
        index++;

        TreeNode root = new TreeNode(rootVal);

        //left recursive call
        root.left = helper(preorder, start, rootIdx - 1); //here the start is parent's start

        //right recursive call
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }

    // Using arrays
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         //null
//         if(preorder == null || preorder.length == 0) return null;

//         //get the root
//         int rootVal = preorder[0];
//         TreeNode root = new TreeNode(rootVal);

//         int rootIdx = -1;
//         //find the root in inorder traversal
//         for(int i = 0; i< inorder.length; i++){ // in every recursion call we are going through n elements therefore O(n^2)
//             if(inorder[i] == rootVal){
//                 rootIdx = i;
//             }
//         }

//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx+1);
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);

//         int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1); // (preorder, 1, inLeft+1)
//         int[] preRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);

//         root.left = buildTree(preLeft,inLeft );
//         root.right = buildTree(preRight, inRight);

//         return root;

//     }
}