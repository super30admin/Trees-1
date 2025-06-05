//105. Construct Binary Tree from Preorder and Inorder Traversal
//solved on leetcode and faced no issues
//TC:O(n) SC:O(n)




class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preindex = {0};  //we r starting from 0th index of preorder array initially
        HashMap<Integer,Integer>inordermap  = new HashMap<>();
        for (int i = 0 ; i <inorder.length ; i++){
            inordermap.put(inorder[i] , i);
        }
        return buildtree(preorder , inorder , preindex , 0 , inorder.length-1 , inordermap);

        
    }
    private TreeNode buildtree(int[] preorder , int[] inorder , int[] preindex , int instart , int inend , HashMap<Integer,Integer>inordermap){
        //Base case
        if(preindex[0] >= preorder.length || instart > inend){
            return null;
        }
        int currentval = preorder[preindex[0]];
        TreeNode cnode = new TreeNode(currentval);
        preindex[0]+=1;

        int i = inordermap.get(currentval);

      

        cnode.left = buildtree(preorder , inorder , preindex , instart , i-1 , inordermap );
        cnode.right = buildtree(preorder , inorder , preindex , i+1 , inend , inordermap);
        return cnode;

    }
}

//////////////////////////////////////////

    //Brute force -> TC :  O(n^2) , SC: O(n) 
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int[] preindex = {0};  //we r starting from 0th index of preorder array initially
//         return buildtree(preorder , inorder , preindex , 0 , inorder.length-1);

        
//     }
//     private TreeNode buildtree(int[] preorder , int[] inorder , int[] preindex , int instart , int inend){
//         //Base case
//         if(preindex[0] >= preorder.length || instart > inend){
//             return null;
//         }
//         int currentval = preorder[preindex[0]];
//         TreeNode cnode = new TreeNode(currentval);
//         preindex[0]+=1;

//         int i = -1; // declaring here coz if not declared it will not find in below cnode.left , cnode.right

//         for( i = instart ; i <= inend ; i++){  //setting a range in inorder array (splitting the inorder array)
//             if(inorder[i] == currentval){
//                 break;
//             }
             
//         }

//         cnode.left = buildtree(preorder , inorder , preindex , instart , i-1 );
//         cnode.right = buildtree(preorder , inorder , preindex , i+1 , inend);
//         return cnode;

//     }
// }