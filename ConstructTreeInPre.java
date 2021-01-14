// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was not able to think about left sub tree & right sub tree in inorder

class ConstructTreeInPre {
    Map<Integer, Integer> map; //map for storing indices of inorder values
    int idx; //will increment one by one to get next root value from preorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end){

        if(start > end)
            return null;

        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal); //root index in inorder
        // left sub tree in inorder array
        root.left = helper(preorder, start, rootIndex - 1);
        // right sub tree in inorder array
        root.right = helper(preorder, rootIndex + 1, end);
        return root;
    }
}