
//TC: O(n) - no new arrays
// SC- O(n)  + O(n) = O(n)
class Solution {
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.idx = 0;
        return helper(preorder, 0, preorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        //base case
        if(start > end) return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);

        return root;

    }
}






// with HashMap
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {

//         // base case
//         // we can check inorder also. either is fine.
//         if(preorder.length == 0) return null;

//         int rootVal = preorder[0];

//         int rootIdx = -1;
//         for(int i=0; i<inorder.length; i++) { //O(n)
//             if(inorder[i] == rootVal) {
//                 rootIdx = i;
//                 break;
//             }
//         }
        
//         //O(2n)
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
//         int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
//         int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

//         TreeNode root = new TreeNode(rootVal);
//         root.left = buildTree(preLeft, inLeft);
//         root.right = buildTree(preRight, inRight);

//         return root;
//     }
// }

