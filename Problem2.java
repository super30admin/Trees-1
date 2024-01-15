//Accepted on LT
//The idea is to check for root in pre order and compare it with in order array to know left and right
//Time should be O(n)

class Solution {
    HashMap<Integer,Integer> map;
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }
        return helper(preorder,0,inorder.length-1);
        
    }

    public TreeNode helper(int[] p,int s,int e){
        if(s>e) return null;
        int r = p[idx];
        idx++;
        int ridx = map.get(r);

        TreeNode t = new TreeNode(r);
        t.left = helper(p,s,ridx-1);
        t.right = helper(p,ridx+1,e);
        return t;
    }
}