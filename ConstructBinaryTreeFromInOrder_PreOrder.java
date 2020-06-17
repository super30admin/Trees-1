/*
    1) Approach 1 BruteForce 

    from preorder traversal we will get to know what is the root,
    we can find the left and right of the root from inorder traversal

    Space Compelxity : O(2^n) Each iteration we are creating the space it is exponentially, recursive space O(H)
    Time complexity : O(N)
    worked on leetcode : YES


    Approach 2 : inorder Array handling

    space complexity : O(N)
    time complexiy : O(N)+ O(H)=O(N)
    is worked on leetcode : YES
*/

public class ConstructBinaryTreeFromInOrder_PreOrder {

    public TreeNode buildTree_BruteForce(int[] preorder, int[] inorder) {
        if (preorder.length  == 0  || inorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        int inIdx = -1;
//          find the root position in inorder traversal
        for(int i =0 ;i< inorder.length ;i++){
            if( inorder[i] == preorder[0]) inIdx = i;
        }
        int [] preLeft = Arrays.copyOfRange(preorder,1,inIdx+1);
        int [] preRight =  Arrays.copyOfRange(preorder,inIdx+1, preorder.length);
        int [] inLeft = Arrays.copyOfRange(inorder,0,inIdx);
        int [] inRight =  Arrays.copyOfRange(inorder,inIdx+1, inorder.length);
        
        root.left = buildTree(preLeft,inLeft );
        root.right = buildTree(preRight,inRight);
        
        return root;
    }
    

    HashMap<Integer, Integer> map;
// index in preorder for root
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length  == 0  || inorder.length == 0) return null;
        
        map =  new HashMap<>();
        
        for(int i =0  ;i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode helper(int [] preorder, int[] inorder, int S, int E){
        
        
//         BASE CASE
            if (S > E || index >= preorder.length ) return null;
        
//         LOGIC
//         find the root in inorder traversal using preorder and map
        int inIndex  = map.get(preorder[index]);
        
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, inorder, S, inIndex-1);
        root.right = helper(preorder, inorder, inIndex+1, E);
        return root;
        
    } 
}