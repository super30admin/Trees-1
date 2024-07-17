//TC O(n)
//SC O(n)

class Solution {
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode build(int[] preorder, int s, int e) {
        if(s>e) return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = build(preorder, s, rootIdx-1);
        root.right = build(preorder, rootIdx+1, e);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0 ;i<inorder.length ;i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }
}