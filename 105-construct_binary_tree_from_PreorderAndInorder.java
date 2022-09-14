//Approach-1: Using the approach of creating multiple new arrays
//Overall Time Complexity: O(N^2)
//Overall Space Complexity: O(N^2)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Handling the case when the array is empty
        if(preorder.length == 0) return null;
        
        //First Element of the preorder traversal is always the root
        int currVal = preorder[0];
        TreeNode root = new TreeNode(currVal);
        int indx = -1;
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == currVal){
                indx = i; 
            }
        }
        
        //Making 4 different arrays for traversals
        int[] inL = Arrays.copyOfRange(inorder, 0, indx);
        int[] inR = Arrays.copyOfRange(inorder, indx + 1, inorder.length);
        int[] preL = Arrays.copyOfRange(preorder,1, indx + 1);
        int[] preR = Arrays.copyOfRange(preorder, indx + 1, preorder.length);
        
        root.left = buildTree(preL, inL);
        root.right = buildTree(preR, inR);
        
        return root;
    }
}


//Approach-2: Using the HashMap and two pointers
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(N)
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int indx;
    
    public TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start > end) return null;
        
        int val = preorder[indx];
        TreeNode node = new TreeNode(val);
        indx++;
        int inIndx = map.get(val);
        node.left = helper(preorder, start, inIndx - 1);
        node.right = helper(preorder, inIndx + 1, end);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        
        indx = 0;    
        //Storing inorder data into the HashMap
        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        //Passing the preorder, the start and end for the inorder
        return helper(preorder, 0, inorder.length - 1);
        
    }
}