// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i <inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    private TreeNode helper(int [] preorder,int start, int end){
        //base
        if(start > end) return null;
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}

/*
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        // find rootVal in inorder
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
            }
        }
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inRight = Arrays.copyOfRange(inorder,rootIdx +1,inorder.length);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int [] preRight = Arrays.copyOfRange(preorder, 1 + rootIdx, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}  
*/