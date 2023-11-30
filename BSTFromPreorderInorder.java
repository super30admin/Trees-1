import java.util.Arrays;
import java.util.HashMap;

public class BSTFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) { // we need to optimize this
        //TC:O(n*n)
        //SC:O(n*n)
        // preorder - root , left , right
        // inorder - left , root, right
        if(preorder.length == 0) return null;
        int rIdx = -1;
        int rootVal = preorder[0];
        for(int i= 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rIdx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int[] inLeft = Arrays.copyOfRange(inorder,0,rIdx-1+1); //copyOfRange needs one index extra
        int[] inRight = Arrays.copyOfRange(inorder, rIdx+1, inorder.length -1 + 1);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1+inLeft.length - 1 + 1);
        int[] preRight = Arrays.copyOfRange(preorder, 1+ inLeft.length, preorder.length -1 + 1);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }

    HashMap<Integer, Integer> map;
    int idx; //preorder idx
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        //TC:O(n)
        //SC:O(h)
        // System.gc();
        this.map = new HashMap<>();
        this.idx = 0;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder,0, inorder.length-1, 0);

    }

    private TreeNode helper(int[] preorder, int start, int end, int rIdx){
        //base
        if(start > end) return null;
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);

        rIdx = map.get(root.val);

        root.left = helper(preorder, start, rIdx - 1, rIdx);
        root.right = helper(preorder, rIdx+1, end, rIdx);

        return root;
    }
}
