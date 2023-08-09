//TC O(n)
//SC:O(n)
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    int rootIdx;

    //use map for inorder traversal
    Map<Integer, Integer> iMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        this.iMap = new HashMap<>();
        rootIdx= 0;
        for (int i=0; i< inorder.length; i++) {
            iMap.put(inorder[i], i);
        }

        //call thr function recursively with new start and end
        return helper(preorder, inorder, 0, preorder.length -1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootValue = preorder[rootIdx];
        rootIdx++;
        TreeNode node = new TreeNode(rootValue);

        node.left = helper(preorder, inorder, start, iMap.get(rootValue) -1);
        node.right = helper(preorder, inorder, iMap.get(rootValue) +1, end);
        return node;
    }

}