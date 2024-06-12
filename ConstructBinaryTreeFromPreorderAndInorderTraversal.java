import java.util.HashMap;
import java.util.Map;

//Time - O(n)
//Space - O(n)
class SolutionPreorderInorder {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length){
            return null;
        }

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recurse(preorder, 0, inorder.length-1);
    }
    private TreeNode recurse(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = recurse(preorder, start, rootIdx-1);
        root.right = recurse(preorder, rootIdx+1, end);
        return root;
    }
}