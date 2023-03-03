//T.C-O(N)- Building the hashmap takes O(N) time, as there are N nodes to add, ; 
// S.C- O(N)- using a hashmap extra, recursion calls depends on the height of the tree
import java.util.HashMap;
  public class construct_BT {
      int val;
      construct_BT left;
      construct_BT right;
      construct_BT() {}
      construct_BT(int val) { this.val = val; }
      construct_BT(int val, construct_BT left, construct_BT right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  

 class Solution {
    public construct_BT buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i); //add number and its index
        }
        construct_BT root= construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
//first element of preorder will always be the root, locate that root in inorder and divide the left and right subtrees and again locate the root and repeat(recursion)
        
    }
    public construct_BT construct(int[] preorder, int prestart, int preend, int[]inorder, int inStart, int inEnd,HashMap<Integer, Integer> map){
        if(prestart>preend || inStart>inEnd){
            return null;
        }
        construct_BT root= new construct_BT(preorder[prestart]);
        int inRoot= map.get(root.val);
        int inLeft= inRoot-inStart;

        root.left= construct(preorder, prestart+1, prestart+inLeft, inorder, inStart,inRoot-1,map );
        root.right= construct(preorder, prestart+inLeft+1,preend,inorder, inRoot+1, inEnd, map);
        return root;

    }
}
