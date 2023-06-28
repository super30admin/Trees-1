import java.util.HashMap;
//Time complexity: O(N)
//Space complexity: O(N)
public class ConstructTreeFromPreAndInOrder {
    HashMap<Integer, Integer> inorderMap;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        idx = 0;

        if(preorder.length == 0){
            return null;
        }

        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int begin, int end){
        if(begin > end ){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        int rootIndex = inorderMap.get(root.val);

        root.left = helper(preorder, begin, rootIndex - 1);
        root.right = helper(preorder, rootIndex + 1, end);

        return root;
    }

}
