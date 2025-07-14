class Solution {
    HashMap<Integer,Integer>map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0){
            return null;
        }
        
       map = new HashMap<>();

        for(int i = 0; i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(preorder,0,inorder.length-1);
    }

    private TreeNode createTree(int[]preorder,int start,int end)
    {
        if(start>end){
            return null;
        }


        int rootValue = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootValue);
        int rootIdx = map.get(rootValue);
        
      
        root.left = createTree(preorder,start,rootIdx-1);
        root.right =  createTree(preorder,rootIdx+1,end);

        return root;
    }
}
