//void based 
//time complexity : O(n) for all soltions
//space complexity:O(1)
//void based
class Solution {
    TreeNode prev;
      boolean flag;
   public boolean isValidBST(TreeNode root) {
       this.flag=true;
       inorder(root);
       return flag;
    }
   public void inorder(TreeNode root){
      if(root == null) return;
       inorder(root.left);
      System.out.println(root.val);
      if(prev!= null && root.val <= prev.val){
       flag=false;  
      }
      prev=root;
     inorder(root.right);
     
   }
}


//void and conditional based recursion 

class Solution {
    TreeNode prev;
      boolean flag;
   public boolean isValidBST(TreeNode root) {
       this.flag=true;
       inorder(root);
       return flag;
    }
   public void inorder(TreeNode root){
      if(root == null) return;
       inorder(root.left);
      System.out.println(root.val);
      if(prev!= null && root.val <= prev.val){
       flag=false;  
      }
      prev=root;
   if(flag)  inorder(root.right);
   }
}

//boolean based recursion with prev


class Solution {
    TreeNode prev;
     public boolean isValidBST(TreeNode root) {
       return inorder(root);
    }
   public boolean inorder(TreeNode root){
      if(root == null) return true;
      
      boolean left=  inorder(root.left);
      System.out.println(root.val);

      if(prev!= null && root.val <= prev.val){
      return false;  
      }
      prev=root;
      boolean right= inorder(root.right);
      System.out.println("==="+left+""+right);
      return left && right;
   }
}

// with min and max



class Solution {
    TreeNode prev;
      boolean flag;
   public boolean isValidBST(TreeNode root) {
       this.flag=true;
       Integer min=null;
       Integer max=null;
       inorder(root,min,max);
       return flag;
    }
   public void inorder(TreeNode root,Integer min,Integer max){
      if(root == null) return;
       inorder(root.left,min,root.val);
   //    System.out.println(root.val);
      if(min != null && root.val <= min){
       flag=false;  
      }
       if(max != null && root.val >= max){
       flag=false;  
      }
      prev=root;
   inorder(root.right,root.val,max);
   }
}