// Time Complexity : O(n) traverses through inorder array and another O(n) for recursive calls
// Space Complexity : O(n + h) space of recursive stack which stores node for all recursive calls and n is the total number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    int index = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return preorder(preorder, 0, inorder.length - 1);
    }

    public TreeNode preorder(int[] preorder, int start, int end){
        //base case
        if(start > end){
            return null;
        }

        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);
        index++;

        int rootIndex = map.get(rootVal);
        root.left = preorder(preorder, start, rootIndex - 1);
        root.right = preorder(preorder, rootIndex + 1, end);

        return root;

    }
}
