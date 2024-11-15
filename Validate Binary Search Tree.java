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

 // bruteforce traverse and store in list as inordr that list should be ascending order TC- O(n^2) SC- O(n)


// class Solution {
//     public boolean isValidBST(TreeNode root) {

//         Stack<TreeNode> stack = new Stack<>();
//         List<TreeNode> list = new ArrayList<>();
//         TreeNode current = root;

//         while(current != null || !stack.isEmpty()){

//             while(current != null){ //keep adding till last left node
//                 stack.push(current);
//                 current = current.left;
//             }

//             current = stack.pop();  //current before this statement contains null but here we are 
//             // giving it stack top value that would be last left value in first case
//             list.add(current); // adding poped value to list
//             current = current.right;// that will null in first case
//         }
//           //Check if the list has 0 or 1 elements, which are always sorted
//         if (list == null || list.size() <= 1) {
//             return true;
//         }
//          // Iterate through the list and compare each element with the next one
//         for (int i = 0; i < list.size() - 1; i++) {
//             if (!(list.get(i).val < list.get(i + 1).val)) {
//                 return false; // Found an unsorted pair
//             }
//         }
//         return true; 
//     }
// }

 // take two pointer prev and current in inorder traveral compare these two pointer if prev not less than current 
 // then false. TC- O(n) SC-O(height of tree)
//check for diff scenarios like void , boolean , int global loca; preorder, postorder, inorder
//whenever value depends on the parents keep variables local
//in this case we can not make pre local because it will passed to each helper and recurssion call comes back it 
//it will loose all the updated variables, when function calls comes back it takes back its own refenece, stack stoew
//diff referebces
//so we can not send prev as local but if we send as refenece like in array it will work
//pre post and inorder all three will not work in this case

//  class Solution {
//     TreeNode prev;
//     Boolean flag;
//     public boolean isValidBST(TreeNode root) {
//         this.flag = true;
//         helper(root);
//         return flag;
//     }

//     private void helper(TreeNode node){
//         if(node == null) return;

//         if(flag){//so it wont go to whole tree
//         helper(node.left);//left recursion 
//         //its inorder traversal so after everytime from left node processing done 
//         //it will come back to root of its mini tree tree, basically it will store each f(root) in stack in
//         // left travesal first then when reached to null it will go back to node that it has been called from that
//         //that is its root, then that root function will be poped out of stack proccesed and it will go to right node 
//         // of it.
//         }

//         if(prev!=null && prev.val >= node.val){
//             flag = false;
            
//         }
//         prev = node;
//     if(flag){
//         helper(node.right);
//     }
//     }
 
// }


//validate BST 2.0. find min amx value for each node, that node value should be in that range
//left tree -min - same max - rool.val
//right tree min - root.val max same
//pre post and inorder all three will in this case
//min max global will not work because it depends on parant value
//do it with boolean return type also
class Solution {
    
    Boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root,Integer min, Integer max){
        if(root == null) return;

       

        if(min!=null && root.val <=min) flag = false;
        if(max!=null && root.val >= max) flag = false;

         if(flag){//so it wont go to whole tree
        helper(root.left, min, root.val);//left recursion 
        //its inorder traversal so after everytime from left node processing done 
        //it will come back to root of its mini tree tree, basically it will store each f(root) in stack in
        // left travesal first then when reached to null it will go back to node that it has been called from that
        //that is its root, then that root function will be poped out of stack proccesed and it will go to right node 
        // of it.
        }

       
    if(flag){
        helper(root.right, root.val, max);
    }
    }
 
}


