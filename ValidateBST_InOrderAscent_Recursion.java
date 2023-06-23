import java.util.List;
import java.util.ArrayList;

public class ValidateBST_InOrderAscent_Recursion {


        public boolean isValidBST(TreeNode root) {

            List<Integer> arl = new ArrayList<>();

            inorder(root, arl);

            for(int i = 1; i < arl.size(); i++) {

                if(arl.get(i-1) >= arl.get(i))  return false;

                //System.out.print(arl.get(i));
            }

            return true;
        }

        private void inorder(TreeNode root, List<Integer> arl){


            //base
            if(root == null) return;

            //logic
            //System.out.print("push  ");
            //System.out.println(root.val);

            inorder(root.left, arl);

            arl.add(root.val);

            inorder(root.right, arl);

            //System.out.print("pop  ");
            //System.out.println(root.val);
            //st.pop() and root reset to parent where it is called from


        }

}
