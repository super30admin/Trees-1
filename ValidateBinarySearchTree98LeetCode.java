
//Time Complexity: O(n) n = number of elements
//Space Complexity: O(n)
//didn't face any problems
//runs successfully



//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class ValidateBinarySearchTree98LeetCode {


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

        private long previous;                              //maintaing the previous node's value

        public boolean isValidBST(TreeNode root) {

            previous = Long.MIN_VALUE;                      //assign the value to minimum
            return validBST(root);                          //call the recursive function

        }

        private boolean validBST(TreeNode root){

            //base
            if(root == null){                           //check if node is null or not
                return true;                            //if so, return true
            }

            //left
            boolean validLeft = validBST(root.left);    //call the recursive function and pass the root's left node

            //current
            // if(root.val<=previous){
            //     return false;
            // }
            boolean validCurrent = true;
            if(root.val <= previous){               //check if current value is less than the previous value
                validCurrent = false;               //set validCurrent flag to false
            }
            previous = root.val;                    //update the previous value to current node's value


            //right
            boolean validRight = validBST(root.right);      //call the recusrive function by passing the root's right node


            // return validLeft && validRight;

            return validLeft && validRight && validCurrent;     //check is left, current and right flag is true or not

        }


//        long previous;
//        boolean flag;

//     public boolean isValidBST(TreeNode root) {

//         previous = Long.MIN_VALUE;
//         flag = true;
//         validBST(root);


//         return flag;
//     }

//     private void validBST(TreeNode root){

//         //base
//         if(root == null){
//             return;
//         }

//         //left
//         validBST(root.left);

//         //current
//         if(root.val<=previous){
//             flag = false;
//         }
//         previous = root.val;


//         //right
//         validBST(root.right);

//     }








//     List<Integer> list;

//     public boolean isValidBST(TreeNode root) {

//         list = new ArrayList<>();
//         validBST(root);

//         for(int i=1; i<list.size();i++){

//             if(list.get(i)<=list.get(i-1)){
//                 return false;
//             }
//         }

//         return true;
//     }

//     private void validBST(TreeNode root){

//         //base
//         if(root == null){
//             return;
//         }

//         //left
//         validBST(root.left);

//         //current
//         list.add(root.val);


//         //right
//         validBST(root.right);

//     }
}
