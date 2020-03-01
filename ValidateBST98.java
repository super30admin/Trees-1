import java.util.ArrayList;

//time complexity : O(n)
//space complexity : logn if it's balanced tree
//leet code execution : successful
//steps : in BST, nodes to the left will be lessthan parent node and right nodes will always be greater than parent node. while recurssing through Left and right side of tree to determine it's leaf node. check for null condition. i.e. when leaf encounters it'll not have further nodes so they return null.

 
class ValidateBST98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    

    TreeNode root = null;
    public ValidateBST98(ArrayList<Integer> al){
        root = new TreeNode(al.get(0)) ;
        for(int i =1; i<al.size();i++){
            int element = al.get(i);
            TreeNode val = null;
            TreeNode currVal = root;
        
        while(currVal!=null){
            val = currVal;
            currVal = element < currVal.val ? currVal.left : currVal.right;
            if(element<val.val){
                val.left = new TreeNode(element);
            }
            else {
                val.right = new TreeNode(element);
            }
        }



        }
    }
    public boolean isValidBST(TreeNode root) {

        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;
        if ((low != null && node.val <= low) || (high != null && node.val >= high))
            return false;
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
  
 

  

            

public static void main(String[] args) {

    ArrayList<Integer> al  = new ArrayList<Integer>();
    al.add(3);
    al.add(2);
    al.add(1);
    al.add(4);
    al.add(5);
    al.add(6);
    al.add(7);
    ValidateBST98 vs = new ValidateBST98(al);
    System.out.println(vs.isValidBST(vs.root));
}
}