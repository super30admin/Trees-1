// TC: O(N)
// SC: O(N)
class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map=new HashMap<>();
        this.idx=0;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);
    }


    private TreeNode helper(int[] preorder, int start, int end){
        //base condition 
        if(start>end) return null;

        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = helper(preorder,start,rootIdx-1);

        root.right = helper(preorder,rootIdx+1,end);

        return root;
    }
}