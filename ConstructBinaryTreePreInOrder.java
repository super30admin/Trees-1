//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using hashmap to store the idx of inorder to find root idx
//recursion : local : preorder,inorder,start,end ; global : map,idx
class Solution {
    HashMap<Integer, Integer> map ;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map= new HashMap<>();
        this.idx=0;
        for(int i=0; i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        // base case
        if(start> end) return null;
        //logic
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx= map.get(rootVal);
        root.left =  helper(preorder, inorder, start, rootIdx-1);
        root.right =  helper(preorder, inorder,rootIdx+1, end);
        return root;
    }
}




//Time Complexity: O(n^2)
//Space Complexity: O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//using recursion: 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0) return null;

        if(preorder.length==0) return null;

        int rootVal = preorder[0];
        int rootIdx= -1;

        TreeNode root =new TreeNode(rootVal);

        for(int i=0; i<inorder.length;i++){
            if(inorder[i] == rootVal){
                rootIdx=i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder , 0 , rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder , rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1 , preorder.length);

        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);

        return root;


        
        
    }
}