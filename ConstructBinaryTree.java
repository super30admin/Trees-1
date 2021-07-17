
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

public class ConstructBinaryTree {
    Map<Integer, Integer> map;
    int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        map = new HashMap<>();

        // store inorder nodes and indices in hashmap
        for(int i = 0 ; i< inorder.length ; i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,inorder,0, inorder.length-1);
    }

    private TreeNode helper( int[] preorder,int[] inorder, int start, int end){
        if(start > end) return null;
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper( preorder,inorder, start, rootIdx-1);
        root.right = helper(preorder,inorder, rootIdx+1, end);
        return root;
    }

}