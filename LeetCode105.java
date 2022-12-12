import java.util.HashMap;

public class LeetCode105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || preorder.length == 0)
            return null;
        map = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < inorder.length; i++) {// createing the hasing for the inorder sothat we do have to loop over
                                                  // the inorder to search for the roots index in inorder
            map.put(inorder[i], i);
        }

        return recusrion(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode recusrion(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[idx];// fetching the root from preorder
        idx++;// to fetch the root for subtree

        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);// this is teh place of root in inorder and left subtree will be one less than
                                       // this indx so belwo we are using rootidx-1 and for right subtree we have to
                                       // use rootIdx+1

        root.left = recusrion(preorder, inorder, start, rootIdx - 1);
        root.right = recusrion(preorder, inorder, rootIdx + 1, end);

        return root;
    }
}

// tc==O(n)
// sc-->O(n)-->hash map
