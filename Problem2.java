//Time complexity: O(n)
//space complexity: O(h)

class Solution {
    //we use idx to keep track of the current root in preorder array
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //to find the root index in constant time from inorder array
        HashMap<Integer,Integer> map=new HashMap<>();   
        this.idx=0;

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return helper(preorder,0,inorder.length-1,map);

    }
    private TreeNode helper(int preorder[],int start,int end,HashMap<Integer,Integer> map){
        if(start>end) return null;
        
        int rootVal=preorder[idx];
        idx++;

        //get the root index and create the root node
        int rootidx=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);

        root.left=helper(preorder,start,rootidx-1,map);  //build left subtree
        root.right=helper(preorder,rootidx+1,end,map);  //build right subtree
        return root;
    }
}