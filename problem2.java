// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// to find index of root, we are using hashmap and then using recursion to find the left and right subtree of the root,
//by passing references and not subtree arrays.
class Solution {
    int idx; //iterate on preorder
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start>end) return null;
        //logic
        //find root
        int rootValue = preorder[idx];
        idx++;
        int rootindex= map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left =  helper(preorder, start, rootindex-1);
        root.right = helper(preorder, rootindex+1, end);
        return root;
    }
}

// Time Complexity :O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base case
        if(preorder.length== 0) return null;
        int rootValue = preorder[0];
        int rootIndex = -1;
        TreeNode root = new TreeNode(rootValue);
        //O(n)
        for(int i=0; i<inorder.length; i++){
            if(rootValue == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        //O(n)
        int [] inleft = Arrays.copyOfRange(inorder, 0, rootIndex);
        //O(n)
        int [] inright = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        //O(n)
        int [] preleft = Arrays.copyOfRange(preorder, 1, 1+inleft.length);
        //O(n)
        int [] preright = Arrays.copyOfRange(preorder, 1+inleft.length, preorder.length);
        root. left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        return root;
    }
}