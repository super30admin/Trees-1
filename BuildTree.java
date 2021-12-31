   /*
    TC: O(n)
    SC: O(n)
    */
    class BuildTree{
        HashMap<Integer,Integer> map;
        int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0){
            return null;
        }
        map=new HashMap<>();
        idx=0;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int preorder[],int start,int end){
        //base
        if(start>end){
            return null;
        }

        //logic
        int rootVal=preorder[idx];
        TreeNode root=new TreeNode(rootVal);
        idx++;
        int rootIdx=map.get(rootVal);

        root.left=helper(preorder,start,rootIdx-1);
        root.right=helper(preorder,rootIdx+1,end);
        return root;
    }
}