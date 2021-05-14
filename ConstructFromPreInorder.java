
/*
Desc: We use a hashmap for O(1) retrival of the index from the inorder array, while we consider
the elements in preoreder as the roots and use every next element of it as consecutive roots.
after gettind index for the latter in the inorder array we use recursion to create the nodes at current root
and defy the bounds for the next start and end pointers at the inorder array..
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;
        
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx = 0; 
        return helper(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder,int start,int end){
        if(start>end) return null;
        int rootIdx = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = helper(preorder,inorder, start,rootIdx-1);
        root.right = helper(preorder,inorder,rootIdx+1,end);
        return root;
    }
}
