//Time Complexity : O(n), n is number of elements
//Space Complexity : O(n) (Hash Map)




class Solution {
    //preorder index, to print the current root
    //preorders first element is always the root, and following elements are the root for LST and RST ...
    int pIndex; 
    //globally initinialize map to use in both methods
    HashMap<Integer, Integer> map;   
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //if length == 0, return null
        if(preorder.length == 0 || inorder.length == 0) return null; 
        
        //create hashmap and add inorder elements to search inorder element poistion in O(1). To know where to split the array for LST and RST
        map = new HashMap<>(); 
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        
        //call helper method
        //the pointers point to 0 and inorder.length-1 in the beginning
        return helper(preorder, inorder, 0, inorder.length-1);      
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {        
        //if start > end, then all elements have been added for that call
        //if pIndex >= preorder.length, we have added all elements to the tree
        if(start > end  || pIndex >= preorder.length) return null; 
        
        //Inorder Index
        int iIndex;  
        //search position of current root in Inorder
        iIndex = map.get(preorder[pIndex]);
        //add that value as the root
        TreeNode root = new TreeNode(preorder[pIndex]);    
        //increment pIndex, to get the next root, based on LST or RST
        pIndex++;
        
        //call left and right helper function based on iIndex position.
        //left of iIndex position forms the LST (start to iIndex-1)
        //right of iIndex position forms the RST (iIndex to end)
        root.left = helper(preorder, inorder, start, iIndex-1);
        root.right = helper(preorder, inorder, iIndex+1, end );
        
        //return the root
        return root;      
    }
}

/*
     pI
P - [3,9,20,15,7]
Left of 3 is LST and right of 3 is RST in Inorder input
start is at 0
end is at 7
    LST-RST
I - [9,3,15,20,7]




         pI
P - [3,9,20,15,7]

Left of 20 is LST, right of 20 is RST
start is at 15
end is at 7
I - [9,3,15,20,7]

*/
