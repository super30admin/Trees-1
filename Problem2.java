// Time Complexity :  O(n*n)
// Space Complexity :  O(h)
// Did this code successfully run on Leetcode :  Yes

class Solution1 {

    //keep track of the root from preOrder[]
    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        return buildTreeRec(preorder,inorder,0,inorder.length-1);
    }

    // build the tree using preIndex with preOrder and (start & end) with inOrder
    private TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end){
        if(end<start){
            return null;
        }
        int val= preorder[preIndex];
        //get the index from inOrder
        int index= getIndex(inorder,val);
        //increment preIndex so that we can move to next node in preOrder
        preIndex++;
        TreeNode root= new TreeNode(val);
        //build the tree using left subset and right subset of the root in inOrder
        root.left= buildTreeRec(preorder,inorder,start,index-1);
        root.right= buildTreeRec(preorder,inorder,index+1,end);
        return root;
    }

    private int getIndex(int[] inorder, int val){
        for(int i=0; i<inorder.length; i++){
            int num= inorder[i];
            if(num==val){
                return i;
            }
        }
        return -1;
    }
}


// Time Complexity :  O(n)
// Space Complexity :  O(n+h)
// Did this code successfully run on Leetcode :  Yes

class Solution2 {

    //keep track of the root from preOrder[]
    private int preIndex;
    //map to store indices
    private HashMap<Integer,Integer> map= new HashMap<>();

    private void buildMap(int[] inorder){
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
    }

    // build the tree using preIndex with preOrder and (start & end) with inOrder
    private TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end){
        if(end<start){
            return null;
        }
        int val= preorder[preIndex];
        //get the index from inOrder
        int index= getIndex(val);
        //increment preIndex so that we can move to next node in preOrder
        preIndex++;
        TreeNode root= new TreeNode(val);
        //build the tree using left subset and right subset of the root in inOrder
        root.left= buildTreeRec(preorder,inorder,start,index-1);
        root.right= buildTreeRec(preorder,inorder,index+1,end);
        return root;
    }

    private int getIndex(int val){
        return map.get(val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        buildMap(inorder);
        return buildTreeRec(preorder,inorder,0,inorder.length-1);
    }
}