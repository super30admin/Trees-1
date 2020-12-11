//Time Complexity: O(N)
//Space Complexity: O(N)

class Solution {
    HashMap<Integer,Integer> hmap;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hmap = new HashMap<>();
        if(inorder==null || inorder.length==0){
            return null;
        }
        
        // Adding inorder to hashmap so we can get range of left & right subtree to use it for recursive calls on those subtrees
        // We are using hashmap instead of creating arrayCopy for left and right subtree to get their range
        for(int i  = 0 ; i < inorder.length ; i++){
            hmap.put(inorder[i],i);
        }
        return helper(preorder, 0 , inorder.length-1); 
    }
    
    //We don't need inorder in our helper function as we are utilizing the index to traverse inorder
    private TreeNode helper(int[] preorder, int start, int end){
            // Base Condition
              if(start > end){
                  return null;
              }
            
            // Logic
              int rootVal = preorder[index];  //getting rootnode from preOrder array
              TreeNode root = new TreeNode(rootVal);     //creating TreeNode with rootVal
              index++;        //Incrementing Pointer of preorder
        
            // Getting index of created treeNode from inorder array which divides left & right sub-tree        
            // This eleminates the need for sdubarray & instead we can use pointers to indicate the range of subtrees
              int rootIndex = hmap.get(rootVal);    
              root.left = helper(preorder, start , rootIndex-1);  //Recursive call on left subtree from it's start to root - 1 element  
              root.right = helper(preorder,rootIndex+1,end);  //Recursive call on right subtree from root + 1 to end element
        
            return root;    
    }
}
