// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
//Approach: In this approach we add all the values of the inorder as key and their index as values. Then we keep a start and end pointer in the inorder array.
//we can get the root from the preorder. We can find the index of that root form the hashmap. Then we recurese on the left and right of that root.
class Solution {
    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1);        
    }

    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start>end)return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx= map.get(rootVal);
        root.left = helper(preorder,start, rootIdx-1);
        root.right = helper(preorder,rootIdx+1,end);

        return root;
    }
}


// Time Complexity : O(n^2) 
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes


public class BTfromInandPre {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length ==0)return null;
        int rootVal = preorder[0];
        int rootIdx = -1;
        TreeNode root = new TreeNode(rootVal);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        int [] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inorderRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length );
        int [] preorderLeft = Arrays.copyOfRange(preorder,1,inorderLeft.length+1);
        int [] preorderRight = Arrays.copyOfRange(preorder,inorderLeft.length+1, preorder.length);

        root.left = buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }
    
}
