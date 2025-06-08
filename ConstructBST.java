//time O(n)
//space O(n)
class Solution {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode result = helper(preorder, map, 0,inorder.length-1);

        return result;
    }

    private TreeNode helper(int[] preorder ,Map<Integer, Integer> map, int start, int end){
        //base
        if(start>end) return null;
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, map, start, rootIdx-1);
        root.right = helper(preorder, map, rootIdx+1, end);
        return root;


    }
}