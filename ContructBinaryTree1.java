/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ConstructBinaryTree1 {
    
    
    
    /*
    method 1: time complexity: O(n^2)
              space complexity:O(n^2)
              
              here, preorder first element will be the root always
              then recursively diving the array based on index of root element in inorder
              array.
    */
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//             if(preorder.length == 0){
//                 return null;
//             }
        
        
//         /
//         //first element of preorder array would be the root
//         TreeNode root = new TreeNode(preorder[0]);
        
//         int index = -1;
        
//         //traverse inorder array to find the position of root element
//         for(int i =0 ;i < inorder.length;i++){
//             if(inorder[i] == root.val){
//                 index = i;
//                 break;
//             }
//         }
        
//         //after finding the index of root element divide the arrays in 2 parts
//         //leftIorder, rightInorder, leftPreorder,rightPreorder
        
//         //this will be from 0 to index of inorder array
        
//         int[]leftIorder = Arrays.copyOfRange(inorder,0,index);
//         //this will be from index+1 to inorder.length
//         int[]rightInorder = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
//         int[]leftPreorder = Arrays.copyOfRange(preorder,1,index+1);
//         int[]rightPreorder = Arrays.copyOfRange(preorder,index+1,preorder.length);
        
//         root.left = buildTree(leftPreorder,leftIorder);
//         root.right = buildTree(rightPreorder,rightInorder);
        
            
//         return root;
//     }
    
    
    /*
    method 2: time complexity:O(n)
                space complexity:O(n)
                here, use a extra space to search the root element in inoder array in O(1) time
                
    */
    
//     HashMap<Integer,Integer> map;
   
//     public TreeNode buildTree(int[] preorder, int[] inorder){
//         if(preorder.length == 0){
//             return null;
//         }
        
//         this.map = new HashMap<>();
        
//         //adding all the elements of inorder to map 
        
//         for(int i = 0; i < inorder.length;i++){
//             map.put(inorder[i],i);
//         }
        
//         TreeNode root = new TreeNode(preorder[0]);
        
//         int index = map.get(root.val);
//         int[]left1 = Arrays.copyOfRange(inorder,0,index);
//         int[]right1 = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
//         int[]left2 = Arrays.copyOfRange(preorder,1,index+1);
//         int[]right2 = Arrays.copyOfRange(preorder,index+1,preorder.length);
        
//         root.left = buildTree(left2,left1);
//         root.right = buildTree(right2,right1);
//         return root;
        
//     }
    
    
    //time complexity : O(n)
    //space complexity: O(n)
    HashMap<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        
        this.map = new HashMap<>();
        for(int i =0 ;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        
       return helper(preorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[]preorder,int start,int end){
        if(start > end){
            return null;
        }
        
        
        TreeNode root = new TreeNode(preorder[index]); index++;
        
        root.left = helper(preorder,start, map.get(root.val) -1);
        root.right = helper(preorder,map.get(root.val)+1, end);
        
        return root;
    }
    
}