
//Time complexity: O(N)
//Space Complexity: O(N)

public class Solution {
    HashMap<Integer, Integer> map;
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;

        map = new  HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int start, int end){
        if(start > end)
            return null;

        TreeNode root = new TreeNode(preorder[index]);

        int rootIdx = map.get(preorder[index]);

        index++;

        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);

        return root;
    }
}
