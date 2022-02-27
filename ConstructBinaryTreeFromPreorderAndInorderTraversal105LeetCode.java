//Time Complexity: O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully



//Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}


import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105LeetCode {


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

        Map<Integer, Integer> map;                                              //creating a map
        int preIndex = 0;                                                       //maintaining a preorder index
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            map = new HashMap<>();
            for(int i=0; i<inorder.length; i++){                                //iterating through inorder and put the values and index into map

                map.put(inorder[i], i);

            }

            return buildTree(0, preorder.length-1, preorder);                   //calling the recursive function

        }

        private TreeNode buildTree(int start, int end, int[] preorder){

            if(start>end){                                                      //check if start pointer is greater than end pointer
                return null;                                                    //if so, then return null
            }

            int value = preorder[preIndex++];                                   //get the values from preorder(root node)
            int index = map.get(value);                                         //getting the index of the root value from inorder
            // System.out.println(value);

            TreeNode root = new TreeNode(value);                                //creating the root node
            root.left = buildTree(start, index-1, preorder);                    //calling recursive function and assign it to root's left part
            root.right = buildTree(index+1, end, preorder);                     //calling recursive function and assign it to root's right part

            return root;                                                        //returning the root

        }


//     public TreeNode buildTree(int[] preorder, int[] inorder) {

//         return buildTree(0, 0,inorder.length-1, preorder, inorder);

//     }

//     private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){

//         if(inStart>inEnd){
//             return null;
//         }

//         int value = preorder[preStart];

//         int index = 0;
//         for(int i=0; i<inorder.length; i++){
//             if(inorder[i] == value){
//                 index = i;
//                 break;

//             }

//         }

//         TreeNode root = new TreeNode(value);
//         root.left = buildTree(preStart +1 , inStart, index-1, preorder, inorder);
//         root.right = buildTree( preStart + index-inStart + 1, index+1, inEnd, preorder, inorder);

//         return root;

//     }
}
