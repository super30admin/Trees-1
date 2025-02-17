//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_buildTreeInorderPreorder {
    int currRootInd;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //return helper(preorder, inorder);

        this.currRootInd = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, map, 0, inorder.length-1);
    }

//METHOD : 1
    // public TreeNode helper(int[] preorder, int[] inorder){
    //     //base
    //     if(preorder.length == 0)
    //         return null;
    //     //logic
    //     int rootVal = preorder[0];
    //     TreeNode root = new TreeNode(rootVal);
    //     int rootInd = -1;
    //     for(int i = 0; i < inorder.length; i++){
    //         if(inorder[i] == rootVal){
    //             rootInd = i;
    //             break;
    //         }
    //     }
    //     int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootInd);
    //     int[] inorderRight = Arrays.copyOfRange(inorder, rootInd+1, inorder.length);
    //     int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length+1);
    //     int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length+1, preorder.length);
    //     root.left = helper(preorderLeft, inorderLeft);
    //     root.right = helper(preorderRight, inorderRight);
    //     return root;
    // }

    //METHOD : 2
    public TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int start, int end){
        if(start > end)
            return null;
        int rootVal = preorder[currRootInd];
        currRootInd++;
        int inorderRootInd = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, map, start, inorderRootInd-1);
        root.right = helper(preorder, inorder, map, inorderRootInd+1, end);
        return root;
    }
}
