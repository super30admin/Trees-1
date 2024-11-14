import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


     class Problem1 {
         boolean isValid = true;
         TreeNode prevNode = null;
         public boolean isValidBST(TreeNode root) {

             validateUsingTwoPointer(root);
             return this.isValid;
         }

         /*
      TC : O(N)
      SC : O(H) where H can range from O(logN) for balanced tree and O(N) for skewed tree
       */
         public void validateUsingRange(TreeNode node,Integer minVal,Integer maxValue){
             if(node == null || !this.isValid){
                 return ;
             }
             if(minVal!= null && node.val <= minVal){
                 this.isValid = false;

             }

             validateUsingRange(node.left,minVal,node.val);
             if(maxValue!= null && node.val >= maxValue){
                 this.isValid = false;

             }

             validateUsingRange(node.right,node.val,maxValue);
         }
         /*
         TC : O(N)
         SC : O(H) where H can range from O(logN) for balanced tree and O(N) for skewed tree
          */
         public void validateUsingTwoPointer(TreeNode node){
             if(node == null || ! this.isValid){
                 return ;
             }

             validateUsingTwoPointer(node.left);

             if(prevNode!=null && node.val <= prevNode.val){

                 this.isValid = false;
                 return;
             }

             this.prevNode = node;
             validateUsingTwoPointer(node.right);


         }
     }