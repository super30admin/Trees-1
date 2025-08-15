// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Constructing binary tree one root element at a time from preorder. Construct hashmap for inorder to get index of root in inorder in O(1) time. Using that index, we can find left and right subtree elements in inorder. Recursively calling for left and right subtree.
//Brute force tries to find root index in inorder in O(n) time and creates new arrays for left and right subtree which takes O(n) time. Hence O(n^2). 

class Solution {

    HashMap<Integer,Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0; map = new HashMap();
        for(int i =0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int l, int r){
        if(l>r) return null;

        int rootV = preorder[idx++];
        TreeNode root = new TreeNode(rootV);
        int rootI = map.get(rootV);

        root.left = helper(preorder, l, rootI-1);
        root.right = helper(preorder, rootI+1, r);

        return root;
    }

    public TreeNode buildTreeBrute(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex =-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int [] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int [] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}